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
        
    }

}
