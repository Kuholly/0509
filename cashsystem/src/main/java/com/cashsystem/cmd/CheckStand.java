package com.cashsystem.cmd;

import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Commands;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Account;

/**
 * @className CheckStand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 15:02
 * @Version 1.0
 **/
public class CheckStand extends AbstractCommand {
    public static void main(String[] args) throws Exception {
        Subject subject = new Subject();
        new CheckStand().execute(subject);
    }

    @Override
    public void execute(Subject subject) throws Exception {
        Commands.getCachedHelpCommands().execute(subject);
        while (true){
            System.out.println(">>");
            String line = scanner.nextLine();
            String CommandCode = line.trim().toUpperCase();
            Account account = subject.getAccount();
            if (account == null){
                Commands.getEntranceCommand(CommandCode).execute(subject);
            }else {
                switch (account.getAccountType()){
                    case CUS:
                        Commands.getCustomerCommand(CommandCode).execute(subject);
                        break;
                    case ADMIN:
                        Commands.getAdminCommand(CommandCode).execute(subject);
                        break;
                        default:
                }
            }
        }
    }
}
