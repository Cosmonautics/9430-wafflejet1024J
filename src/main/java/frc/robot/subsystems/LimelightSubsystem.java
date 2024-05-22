package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.LimelightHelpers;

public class LimelightSubsystem extends SubsystemBase {

    public LimelightSubsystem() {}

    @Override
    public void periodic() {
        // periodic stuff if necessary
    }

    public boolean hasTarget() {
        return LimelightHelpers.getTV("limelight");
    }

    public double getTargetX() {
        return LimelightHelpers.getTX("limelight");
    }

    public double getTargetY() {
        return LimelightHelpers.getTY("limelight");
    }

    public double getTargetArea() {
        return LimelightHelpers.getTA("limelight");
    }

    public void setLEDOn() {
        LimelightHelpers.setLEDMode_ForceOn("limelight");
    }

    public void setLEDOff() {
        LimelightHelpers.setLEDMode_ForceOff("limelight");
    }

    public void setLEDBlink() {
        LimelightHelpers.setLEDMode_ForceBlink("limelight");
    }

    public double calculateDistanceToTarget(boolean isRed) {
        double limelightMountAngleDegrees = 30.0;

        // distance from the center of the Limelight lens to the floor
        double limelightLensHeightInches = 5.0;

        // distance from the target to the floor
        double goalHeightInches = 57.5;

        double angleToGoalDegrees = limelightMountAngleDegrees + LimelightHelpers.getTY("limelight");
        double angleToGoalRadians = Math.toRadians(angleToGoalDegrees);

        // calculate distance
        return (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
    }
}
