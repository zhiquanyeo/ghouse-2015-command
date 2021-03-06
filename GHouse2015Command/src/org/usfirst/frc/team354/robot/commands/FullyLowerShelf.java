package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FullyLowerShelf extends Command {

    public FullyLowerShelf() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shelf);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.lift.encoderHasBeenReset() && Robot.lift.encoderValue() > Constants.LIFT_MID_MARK)
    		Robot.shelf.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.shelf.isFullyLowered();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shelf.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
