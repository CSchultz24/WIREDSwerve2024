package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;


public class Conveyor extends SubsystemBase {
    
    private CANSparkMax topIntakeMotor;
    private CANSparkMax bottomIntakeMotor;
    private CANSparkMax conveyorMotor;
    private CANSparkMax shooterMotor;
    private Timer t_Timer = new Timer();
    public Conveyor(){
        topIntakeMotor = new CANSparkMax(Constants.Conveyor.topIntakeMotorID, MotorType.kBrushless);
        bottomIntakeMotor = new CANSparkMax(Constants.Conveyor.bottomIntakeMotorID, MotorType.kBrushless);
        conveyorMotor = new CANSparkMax(Constants.Conveyor.transportMotorID, MotorType.kBrushless);
        shooterMotor = new CANSparkMax(Constants.Conveyor.shooterMotorID, MotorType.kBrushless);
    }

    public void runIntake(){
        topIntakeMotor.set(-1);
        bottomIntakeMotor.set(1);
        conveyorMotor.set(0.5);
        //shooterMotor.set(1);
    }

    public void stopIntake(){
        topIntakeMotor.set(0);
        bottomIntakeMotor.set(0);
        conveyorMotor.set(0);
        //shooterMotor.set(0);  
    }

    public void runConveyor(){
        conveyorMotor.set(0.2);
        shooterMotor.set(0.2); 
    }

    public void stopConveyor(){
        conveyorMotor.set(0);
        shooterMotor.set(0);  
    }

    public void shoot(){
        shooterMotor.set(1);
    }

    public void dontShoot(){
        shooterMotor.stopMotor();
    }

    public void reverseConveyor(){
        shooterMotor.set(-0.5);
        conveyorMotor.set(-0.5);
    }

    public void dontReverse(){
        shooterMotor.set(0);
        conveyorMotor.set(0);
    }

    public void autonShoot(){
        
        t_Timer.start();

        while(t_Timer.get() <= 1){
            shooterMotor.set(1);
        }
        while(t_Timer.get() > 1 && t_Timer.get() <= 3){
            conveyorMotor.set(0.5);
        }
        t_Timer.stop();
        t_Timer.reset();
        shooterMotor.stopMotor();
        conveyorMotor.stopMotor();
    }

}
