package frc.robot.autos;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Conveyor;
import java.util.List;

public class moreStupidAuto extends SequentialCommandGroup {
    public moreStupidAuto(Swerve s_Swerve, Conveyor c_Conveyor){

        addCommands(
            new InstantCommand(() -> c_Conveyor.autonShoot()),
            new InstantCommand(() -> s_Swerve.stupidTrajectory(1, 0)),
            /*new InstantCommand(() -> c_Conveyor.autoIntake())*/ new InstantCommand(() -> s_Swerve.stupidTrajectory(1, 0)));
    }

}
