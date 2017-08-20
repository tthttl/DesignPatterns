package behavioral.command;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RemoteControl {

    Queue<Command> commands = new LinkedBlockingQueue<>();

    public void addCommand (Command command){
        commands.add(command);
    }

    public void executeCommands (){
        this.commands.stream().forEach(Command::execute);
    }


}
