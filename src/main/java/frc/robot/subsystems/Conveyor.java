package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;


public class Conveyor extends SubsystemBase {
    
    private CANSparkMax topIntakeMotor;
    private CANSparkMax bottomIntakeMotor;
    private CANSparkMax conveyorMotor;
    private CANSparkMax shooterMotor;

    public Conveyor(){
        topIntakeMotor = new CANSparkMax(Constants.Conveyor.topIntakeMotorID, MotorType.kBrushless);
        bottomIntakeMotor = new CANSparkMax(Constants.Conveyor.bottomIntakeMotorID, MotorType.kBrushless);
        conveyorMotor = new CANSparkMax(Constants.Conveyor.transportMotorID, MotorType.kBrushless);
        shooterMotor = new CANSparkMax(Constants.Conveyor.shooterMotorID, MotorType.kBrushless);
    }

    public void runIntake(){
        topIntakeMotor.set(-0.5);
        bottomIntakeMotor.set(0.5);
        conveyorMotor.set(0.5);
        shooterMotor.set(0.5);
    }

    public void stopIntake(){
        topIntakeMotor.set(0);
        bottomIntakeMotor.set(0);
        conveyorMotor.set(0);
        shooterMotor.set(0); 
    }

}
