package org.usfirst.frc.team354.robot.commands;

import org.usfirst.frc.team354.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveShelfToPoint extends Command {
	
	private int targetPoint;
	
	private static final int BUFFER = 5;
	
    public MoveShelfToPoint(int target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	targetPoint = target;
    	
    	requires(Robot.shelf);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//negative numbers -> lowered
    	//TODO Please make sure
    	if (Robot.shelf.encoderValue() < targetPoint - BUFFER) {
    		//we are lower, go up
    		Robot.shelf.raise();
    	}
    	else if (Robot.shelf.encoderValue() > targetPoint + BUFFER) {
    		Robot.shelf.lower();
    	}
    	else {
    		Robot.shelf.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.shelf.encoderValue() >= targetPoint - BUFFER &&
        		Robot.shelf.encoderValue() <= targetPoint + BUFFER);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shelf.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
