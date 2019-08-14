package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;

/**
 * @className QuitCommand
 * @Description TODO
 * @Author
 * @Date 2019/8/4 11:41
 * @Version 1.0
 **/
@CommandMeta(
        name = "TCXT",
        desc = "退出系统",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("退出系统，换用下次使用");


    }
}
