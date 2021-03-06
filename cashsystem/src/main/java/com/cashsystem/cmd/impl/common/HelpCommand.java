package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Command;
import com.cashsystem.cmd.impl.Commands;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Account;

import java.util.*;

/**
 * @className HelpCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:41
 * @Version 1.0
 **/
@CommandMeta(
        name = "BZXX",
        desc = "帮助信息",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class HelpCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("HelpCommand");
        Account account = subject.getAccount();
        if (account == null){
            entranceHelp();
        }else {
            switch (account.getAccountType()){
                case CUS:
                    customerHelp();
                    break;
                case ADMIN:
                    adminHelp();
                    break;
                    default:
            }
        }
    }
    //Map.values() 方法，会返回所有的values的集合
    public void entranceHelp(){
        print("欢迎", Commands.ENTRANCE_COMMANDS.values());

    }
    public void adminHelp(){
        print("管理端", Commands.ADMIN_COMMANDS.values());

    }
    public void customerHelp(){
        print("客户端", Commands.CUSTOMER_COMMANDS.values());

    }
    public void print(String title,Collection<Command> collection){
        System.out.println("****************"+title+"***************");
        Map<String,List<String>> helpInfo = new HashMap<>();
        for (Command command:collection){
            CommandMeta commandMeta = command.getClass().
                    getDeclaredAnnotation(CommandMeta.class);

            String group = commandMeta.group();

            List<String> func = helpInfo.computeIfAbsent(group, k -> new ArrayList<>());
            func.add(commandMeta.desc()+"("+commandMeta.name()+")");

        }
        int i = 0;
        //entrySet:取出键值对的集合 getKey(),getValues()
        for (Map.Entry<String,List<String>> entry:helpInfo.entrySet()){
            i++;
            System.out.println(i + "." +entry.getKey());
            int j = 0;
            for (String item:entry.getValue()){
                j++;
                System.out.println("\t" + (i) +" ." +(j) +" "+item);

            }

        }
        System.out.println("输入菜单括号后面的编号(忽略大小写），进行下一步操作");
        System.out.println("************************************");
    }
}
