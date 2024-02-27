package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Conveyor;
import java.util.function.DoubleSupplier;

public class TeleopConveyor extends Command{
    private Conveyor c_Conveyor;
    private DoubleSupplier conveyorValue;
    private DoubleSupplier reverseConveyorValue;

    public TeleopConveyor(
        Conveyor conveyor,
        DoubleSupplier conveyorValue,
        DoubleSupplier reverseConveyorValue
    ){
        c_Conveyor = conveyor;
        addRequirements(c_Conveyor);

        this.conveyorValue = conveyorValue;
        this.reverseConveyorValue = reverseConveyorValue;
    }

    public void execute(){
        double conveyorRun = MathUtil.applyDeadband(conveyorValue.getAsDouble(), Constants.Swerve.stickDeadband);
        double reverseConveyor = MathUtil.applyDeadband(reverseConveyorValue.getAsDouble(), Constants.Swerve.stickDeadband);

        //c_Conveyor.runConveyor(conveyorRun);
        //c_Conveyor.reverseConveyor(reverseConveyor);
    }
}
