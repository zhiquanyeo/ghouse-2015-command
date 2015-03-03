package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShelfReceiveMode extends Command {

    public ShelfReceiveMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shelf);
    	requires(Robot.shelfRollers);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Turn on the shelf rollers
    	Robot.shelfRollers.startRollers();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shelf.hasLoad();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shelfRollers.stopRollers();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
