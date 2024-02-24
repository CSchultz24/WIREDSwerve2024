package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Hooks extends SubsystemBase{
    
    private double hookMaxLength;

    private CANSparkMax leftHookMotor;

    private CANSparkMax rightHookMotor; //instance variables

    private RelativeEncoder leftHookEncoder;

    private RelativeEncoder rightHookEncoder;

   
    //define hooks just one
    public Hooks(){
        hookMaxLength = Constants.Hooks.hookLength; //constructor

        leftHookMotor = new CANSparkMax(Constants.Hooks.leftHookMotorID, MotorType.kBrushless);

        rightHookMotor = new CANSparkMax(Constants.Hooks.rightHookMotorID, MotorType.kBrushless);

        

        leftHookEncoder = leftHookMotor.getEncoder();

        rightHookEncoder = rightHookMotor.getEncoder();

    }
    // runs periodically during teleop
    public void periodic(){ 
        SmartDashboard.putNumber("Encoder left hook", leftHookEncoder.getPosition());
        SmartDashboard.putNumber("Encoder right hook", rightHookEncoder.getPosition());
    }
    //checking stick imput to move the hook 
    public void setHookToJoystick(double stickInput){
        leftHookMotor.set(stickInput);
        rightHookMotor.set(stickInput);
    }

}
