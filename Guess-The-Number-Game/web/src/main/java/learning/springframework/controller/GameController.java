package learning.springframework.controller;

import learning.springframework.service.GameService;
import learning.springframework.util.AttributeNames;
import learning.springframework.util.GameMappings;
import learning.springframework.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    // Request Methods
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("Model: {}", model);
        
        return (gameService.isGameOver()) ? ViewNames.GAME_OVER : ViewNames.PLAY;
    }
    
    @GetMapping(GameMappings.RESTART)
    public String restart(Model model) {
      log.info("Restarting the game to play again.");
      
      gameService.reset();
      
      return GameMappings.REDIRECT_PLAY;
    }
  
  @GetMapping(GameMappings.HOME)
  public String home() {
    gameService.reset();
    
    return ViewNames.HOME;
  }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess)
    {
        log.info("Guess: {}", guess);

        gameService.checkGuess(guess);

        return GameMappings.REDIRECT_PLAY;
    }
    
    
}
