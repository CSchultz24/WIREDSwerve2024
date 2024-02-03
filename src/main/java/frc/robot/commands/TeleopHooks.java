package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;
import java.util.function.DoubleSupplier;

public class TeleopHooks extends Command{
    private Hooks h_hooks;
    private DoubleSupplier hookValue;

    public TeleopHooks(
        Hooks h_hooks,
        DoubleSupplier hookValue){
            this.h_hooks = h_hooks;
            addRequirements(h_hooks);

            this.hookValue = hookValue;
        }

    public void execute(){
        double hookTranslation = hookValue.getAsDouble();

        h_hooks.setHookToJoystick(hookTranslation);
    }
}
