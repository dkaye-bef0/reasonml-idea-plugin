package com.reason.bs;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessListener;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.vfs.VirtualFile;
import com.reason.ide.RmlNotification;
import org.jetbrains.annotations.Nullable;

public class BsCompiler {

    private KillableColoredProcessHandler m_bsb;
    private GeneralCommandLine m_fullCommandLine;
    private GeneralCommandLine m_standardCommandLine;
    private ProcessListener m_outputListener;

    BsCompiler(VirtualFile baseDir, String bsbPath) {
        String canonicalPath = baseDir.getCanonicalPath();
        m_fullCommandLine = new GeneralCommandLine(bsbPath, "-clean-world", "-make-world").withWorkDirectory(canonicalPath);
        m_standardCommandLine = new GeneralCommandLine(bsbPath).withWorkDirectory(canonicalPath);
        recreate(CliType.cleanMake);
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
    public ProcessHandler recreate(CliType cliType) {
        try {
            killIt();
            m_bsb = new KillableColoredProcessHandler(cliType == CliType.cleanMake ? m_fullCommandLine : m_standardCommandLine);
            if (m_outputListener != null) {
                m_bsb.addProcessListener(m_outputListener);
            }
            return m_bsb;
        } catch (ExecutionException e) {
            Notifications.Bus.notify(new RmlNotification("Bsb", "Can't run bsb\n" + e.getMessage(), NotificationType.ERROR));
        }

        return null;
    }

    void killIt() {
        if (m_bsb != null) {
            m_bsb.killProcess();
            m_bsb = null;
        }
    }

    public void addListener(ProcessListener outputListener) {
        m_outputListener = outputListener;
        if (m_bsb != null) {
            m_bsb.addProcessListener(outputListener);
        }
    }
}
