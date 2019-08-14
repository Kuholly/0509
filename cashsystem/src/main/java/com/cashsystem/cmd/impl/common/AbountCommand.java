package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @className AbountCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:41
 * @Version 1.0
 **/
@CommandMeta(
        name = "GYXT",
        desc = "关于系统",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class AbountCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("**************************************");
        System.out.println("********基于字符界面的收银系统********");
        System.out.println("*************作者：付欣***************");
        System.out.println("**********时间：2019年8月4日**********");
        System.out.println("**************************************");
    }
}