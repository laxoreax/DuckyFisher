import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
	
	
	
	@ScriptManifest(name = "DuckyFisher", author = "Ducky", version = 0.37, info = "Learn fishing like a pro, from a duck.", logo = "https://puu.sh/AFytw.png")
	
	public class DuckyFisher extends Script {
		DuckyFisherGUI popup = new DuckyFisherGUI();
		
		
		

	    @Override
	    public void onStart() throws InterruptedException {
	    log("Booting up Ducky Fisher.");
	    	log("Version " + getVersion());
	    	popup.frame.setVisible(true);
	    	
	    	
	    }
	    
	    @Override

	    public void onExit() {
	    	
	    }
	    
	    
	    @Override

	    public int onLoop() {
	    	NPC tutor = npcs.closest("Fishing tutor");
	    	NPC fish = npcs.closest("Fishing spot");
	    	if (popup.frame.isActive()) {
	    		
	    	} else
	    		if (Global.scriptStarted == true) {
	    			log("Starting Script.");
	    			log(Global.currentLocation + " Location Selected.");
	    			log ("Walking to " + Global.currentLocation);
	    			
	    			/**
	    			 * Lumbridge
	    			 */
	    			if (Global.currentLocation.equals(Global.Location.LUMBRIDGE)) {
	    				
	    				if (inventory.isFull()) {
	    					inventory.dropAll("Raw shrimps", "Raw Anchovies");
	    				}
	    				if (getDialogues().isPendingContinuation()) {
	    					getDialogues().clickContinue();
	    				}
	    				if (myPlayer().isInteracting(fish)) {
	    					Sleep.sleepUntil(() -> myPlayer().isAnimating(), 5000);
	    					log("Fishing.");
	    				} else {
		    			if (inventory.contains("Small fishing net")) {
		    			fish.interact("Net");
		    			}
	    				//if player has fishing net & in lumbridge > go fishing
		    			if (getDialogues().inDialogue() && inventory.contains("Small fishing net")) {
		    				walking.walk(new Position(3240, 3153, 0));
	    				}
	    				if (!inventory.contains("Small fishing net")) {
	    					//if dialogue is open obtain fishing net option 1
	    					if (getDialogues().inDialogue()) {
		    					getDialogues().selectOption(1);
		    					getDialogues().clickContinue();
	    					}
	    					else
	    					{
	    					//if not in dialogue talk to fishing tutor
	    					log("Small fishing net not found");
	    					walking.webWalk(new Position(3241, 3157, 0));
	    					tutor.interact("Talk-to");
	    					getDialogues().selectOption(1);
		    			}
	    					//if player is not in lumbridge, go to fishing spot!
	    					if (!myPlayer().getPosition().equals(Global.Location.LUMBRIDGE)) {
		    				walking.webWalk(new Position(3241, 3157, 0));
		    				}
		    			}
	    				}
	    			}
	    			
	    			/**
	    			 * Draynor
	    			 */
	    			if (Global.currentLocation.equals(Global.Location.DRAYNOR)) {
	    				walking.webWalk(new Position(3119, 3215, 0));
	    			}
	    		}
	    	
	    	int rn = (int )(Math.random() * 7000 + 1);
	    	if (rn <= 3000) {
	    		rn = 4000;
	    	}
	    	
	        return rn; //The amount of time in milliseconds before the loop starts over
	    }

	    
	    
	    @Override

	    public void onPaint(Graphics2D g) {
	    	int beginningXp = skills.getExperience(Skill.FISHING); 
	    	int currentXp = skills.getExperience(Skill.FISHING);
	    	int xpGained = currentXp - beginningXp;
	    	
	    	g.setColor(Color.white);
	    	g.drawString("Location " + Global.currentLocation + ".", 10, 37);
	    	g.drawString("Xp Gained: " + xpGained, 10, 55);
	    	g.drawRect(8, 23, 160, 35);
	    }

	}
	    


	
	