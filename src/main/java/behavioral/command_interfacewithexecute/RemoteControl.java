package behavioral.command_interfacewithexecute;

import java.util.LinkedList;
import java.util.Queue;

public class RemoteControl {

    Queue<Command> commands = new LinkedList<>();

    public void addCommand (Command command){
        commands.add(command);
    }

    public void executeCommands (){
        this.commands.forEach(Command::execute);
    }


}
