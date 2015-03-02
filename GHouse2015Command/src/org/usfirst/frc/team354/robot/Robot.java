
package org.usfirst.frc.team354.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team354.robot.subsystems.Chassis;
import org.usfirst.frc.team354.robot.subsystems.Lift;
import org.usfirst.frc.team354.robot.subsystems.LiftRollers;
import org.usfirst.frc.team354.robot.subsystems.Shelf;
import org.usfirst.frc.team354.robot.subsystems.ShelfLockServos;
import org.usfirst.frc.team354.robot.subsystems.ShelfRollers;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Subsystems
	public static final Chassis chassis = new Chassis();
	
	public static final Lift lift = new Lift();
	public static final LiftRollers liftRollers = new LiftRollers();
	
	public static final Shelf shelf = new Shelf();
	public static final ShelfRollers shelfRollers = new ShelfRollers();
	
	public static final ShelfLockServos shelfServos = new ShelfLockServos();
	
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		
		//We should send the lift down and close the hatch and reset all encoders
		
		//Initialize all subsystems
		lift.initialize();
		shelf.initialize();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        dumpDashboardData();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dumpDashboardData();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * Send the current state of the robot to the dashboard
     */
    private void dumpDashboardData() {
    	//Lift Status
    	SmartDashboard.putBoolean(Constants.DASH_LIFT_ENCODER_OK, lift.encoderHasBeenReset());
    	SmartDashboard.putNumber(Constants.DASH_LIFT_ENCODER_VALUE, lift.encoderValue());
    	
    	//Shelf Status
    	SmartDashboard.putBoolean(Constants.DASH_SHELF_ENCODER_OK, shelf.encoderHasBeenReset());
    	SmartDashboard.putNumber(Constants.DASH_SHELF_ENCODER_VALUE, shelf.encoderValue());
    	
    	//Sub System Status
    	SmartDashboard.putData(lift);
    	SmartDashboard.putData(shelf);
    	SmartDashboard.putData(chassis);
    	SmartDashboard.putData(liftRollers);
    	SmartDashboard.putData(shelfRollers);
    	
    	//Commands
    	SmartDashboard.putData(Constants.DASH_CURRENT_COMMAND, Scheduler.getInstance());
    }
}
