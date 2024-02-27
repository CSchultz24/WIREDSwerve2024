package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;
import java.util.function.DoubleSupplier;

public class TeleopHooks extends Command{
    private Hooks h_hooks;
    private DoubleSupplier rightHookValue;
    private DoubleSupplier leftHookValue;

    public TeleopHooks(
        Hooks h_hooks,
        DoubleSupplier rightHookValue,
        DoubleSupplier leftHookValue){
            this.h_hooks = h_hooks;
            addRequirements(h_hooks);

            this.rightHookValue = rightHookValue;

            this.leftHookValue = leftHookValue;
        }

    public void execute(){
        double rightHookTranslation = MathUtil.applyDeadband(rightHookValue.getAsDouble(), Constants.Swerve.stickDeadband);
        double leftHookTranslation = MathUtil.applyDeadband(leftHookValue.getAsDouble(), Constants.Swerve.stickDeadband);

        h_hooks.setRightHookToJoystick(rightHookTranslation);
        h_hooks.setLeftHookToJoystick(leftHookTranslation);
    }
}
