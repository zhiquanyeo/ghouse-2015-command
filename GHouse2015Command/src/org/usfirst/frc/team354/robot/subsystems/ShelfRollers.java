package org.usfirst.frc.team354.robot.subsystems;

import org.usfirst.frc.team354.robot.Constants;
import org.usfirst.frc.team354.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShelfRollers extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController rollerMotor;
	
	public ShelfRollers() {
		rollerMotor = new Talon(RobotMap.shelfRoller);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startRollers(boolean reverse) {
    	if (reverse) {
    		rollerMotor.set(-Constants.SHELF_ROLLER_SPEED);
    	}
    	else {
    		rollerMotor.set(Constants.SHELF_ROLLER_SPEED);
    	}
    }
    
    public void startRollers() {
    	startRollers(false);
    }
    
    public void stopRollers() {
    	rollerMotor.set(0);
    }
}

