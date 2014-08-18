package org.nasa.jpl;
import org.nasa.jpl.coms.MarsRoverComService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarsRoverController {
	
		MarsRoverComService mrcs = new MarsRoverComService();
		
		
		@RequestMapping(value="/send")
		public @ResponseBody String sendCommands(
				@RequestParam(value = "commands", required = true) String commands) {
						
			String message = "Mars rover new position :";
			
			String[] splitCmds=commands.split(" ");
			String[] splitpos=splitCmds[0].split(",");
			
			int pX = Integer.parseInt(splitpos[0]);
			int pY = Integer.parseInt(splitpos[1]);
			String pO = splitpos[2].toUpperCase();
			
			
			mrcs.setInitialPosition(pX, pY, pO);
			String finalPosition = mrcs.sendCommands(splitCmds[1]);
			
			return message+finalPosition;
		}
		
		
		
}
