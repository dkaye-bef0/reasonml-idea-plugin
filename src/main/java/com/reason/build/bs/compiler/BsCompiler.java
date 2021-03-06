package com.reason.build.bs.compiler;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.vfs.VirtualFile;
import com.reason.Platform;
import com.reason.build.CompilerLifecycle;
import com.reason.build.bs.ModuleConfiguration;
import com.reason.ide.RmlNotification;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.intellij.notification.NotificationListener.URL_OPENING_LISTENER;
import static com.intellij.notification.NotificationType.ERROR;

public final class BsCompiler implements CompilerLifecycle {

    private final ModuleConfiguration m_moduleConfiguration;

    private BsProcessHandler m_bsb;
    private RawProcessListener m_outputListener;
    private final AtomicBoolean m_started = new AtomicBoolean(false);
    private final AtomicBoolean m_restartNeeded = new AtomicBoolean(false);

    public BsCompiler(ModuleConfiguration moduleConfiguration) {
        m_moduleConfiguration = moduleConfiguration;
        // zzz
        VirtualFile baseRoot = Platform.findBaseRoot(moduleConfiguration.getProject());
        VirtualFile sourceFile = baseRoot.findChild("bsconfig.json");
        if (sourceFile != null) {
            recreate(sourceFile, CliType.make);
        }
    }

    @Nullable
    public ProcessHandler getHandler() {
        return m_bsb;
    }

    // Wait for the tool window to be ready before starting the process
    public void startNotify() {
        if (m_bsb != null && !m_bsb.isStartNotified()) {
            try {
                m_bsb.startNotify();
            } catch (Throwable e) {
                // already done ?
            }
        }
    }

    @Nullable
    public ProcessHandler recreate(@NotNull VirtualFile sourceFile, @NotNull CliType cliType) {
        try {
            killIt();
            GeneralCommandLine cli = getGeneralCommandLine(sourceFile, cliType);
            if (cli != null) {
                m_bsb = new BsProcessHandler(cli);
                if (m_outputListener != null) {
                    m_bsb.addRawProcessListener(m_outputListener);
                }
            }
            return m_bsb;
        } catch (ExecutionException e) {
            Notifications.Bus.notify(new RmlNotification("Bsb", "Can't run bsb\n" + e.getMessage(), NotificationType.ERROR));
        }

        return null;
    }

    public void killIt() {
        if (m_bsb != null) {
            m_bsb.killProcess();
            m_bsb = null;
        }
    }

    public void addListener(RawProcessListener outputListener) {
        m_outputListener = outputListener;
        if (m_bsb != null) {
            m_bsb.addRawProcessListener(outputListener);
        }
    }

    @Nullable
    private GeneralCommandLine getGeneralCommandLine(@NotNull VirtualFile sourceFile, CliType cliType) {
        String bsbPath = m_moduleConfiguration.getBsbPath(sourceFile);

        if (bsbPath == null) {
            Notifications.Bus.notify(new RmlNotification("Bsb",
                    "<html>Can't find bsb.\n"
                            + "Working directory is '" + m_moduleConfiguration.getWorkingDir(sourceFile) + "'.\n"
                            + "Be sure that bsb is installed and reachable from that directory, "
                            + "see <a href=\"https://github.com/reasonml-editor/reasonml-idea-plugin#bucklescript\">github</a>.</html>",
                    ERROR, URL_OPENING_LISTENER));
            return null;
        }

        GeneralCommandLine cli;
        switch (cliType) {
            case make:
                cli = new GeneralCommandLine(bsbPath, "-make-world");
                break;
            case cleanMake:
                cli = new GeneralCommandLine(bsbPath, "-clean-world", "-make-world");
                break;
            default:
                cli = new GeneralCommandLine(bsbPath);

        }

        cli.withWorkDirectory(m_moduleConfiguration.getWorkingDir(sourceFile));
        cli.withEnvironment("NINJA_ANSI_FORCED", "1");

        return cli;
    }

    public boolean start() {
        boolean success = m_started.compareAndSet(false, true);
        if (!success) {
            m_restartNeeded.compareAndSet(false, true);
        }
        return success;
    }

    public void terminated() {
        m_started.set(false);
    }

    @SuppressWarnings("unused")
    @NotNull
    private String getMajorVersion(@NotNull VirtualFile sourceFile) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(m_moduleConfiguration.getBsbPath(sourceFile) + " -version");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String[] numbers = reader.readLine().split("\\.");
            return numbers[0];
        } catch (InterruptedException | IOException e) {
            return "";
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
    }

}
