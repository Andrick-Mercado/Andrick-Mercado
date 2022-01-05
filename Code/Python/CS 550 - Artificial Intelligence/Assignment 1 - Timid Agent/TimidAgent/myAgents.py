from pacman import Directions
from game import Agent, Actions
from pacmanAgents import LeftTurnAgent

''' all work below is done by Andrick Mercado '''
class TimidAgent(Agent):
    """
    A simple agent for PacMan
    """

    def __init__(self):
        super().__init__()  # Call parent constructor
        # Add anything else you think you need here

    def inDanger(self, pacman, ghost, dist=3):
        """inDanger(pacman, ghost) - Is the pacman in danger
        For better or worse, our definition of danger is when the pacman and
        the specified ghost are:
           in the same row or column,
           the ghost is not scared,
           and the agents are <= dist units away from one another

        If the pacman is not in danger, we return Directions.STOP
        If the pacman is in danger we return the direction to the ghost.
        """

        x1, y1 = pacman.getPosition()
        x2, y2 = ghost.getPosition()
        #for curGhost in ghost:#iterate through the ghosts
        #if ghost is scared we can continue to its direction
        if ghost.isScared():
            return Directions.STOP
        # makes sure they are in the same column and calculate dist
        if abs(x1-x2) <= dist and y1 == y2:
            # check to see if ghost its to its west or east
            if x1 < x2:
                return Directions.EAST
            return Directions.WEST
        #makes sure they are in the same row and calculate dist
        elif abs(y1-y2) <= dist and x1 == x2:
            #check to see if ghost its to its north or south
            if y1 < y2:
                return Directions.NORTH
            return Directions.SOUTH
        return Directions.STOP

    def getAction(self, state):
        """
        getAction(self, state) - Make a decsion based on the current game state
        state, specifically based on inDanger returning if the pacman is close
        to danger or not by directions, if no danger pacman will continue with
        regular leftTurnAgent format
        returns a valid action direction:  North, East, South, West or
        a Stop action when no legal actions are possible
        """
        # List of directions the agent can choose from
        legal = state.getLegalPacmanActions()

        # Get the agent's state from the game state and find agent heading
        agentState = state.getPacmanState()
        heading = agentState.getDirection()

        if heading == Directions.STOP:
            # Pacman is stopped, assume North (true at beginning of game)
            heading = Directions.NORTH

        # stores direction of danger in isInDanger
        for curGhost in state.getGhostStates():  # iterate through the ghosts
            isInDanger = self.inDanger(state.getPacmanState(), curGhost)
            if isInDanger != Directions.STOP:#if there is danger we cancel loop
                break
        # if the pacman is in danger
        if isInDanger != Directions.STOP:
            # order: U-turn, left, right, head into ghost (straight) and stop if no legal moves
            # make sure its a legal move and danger isnt in that direction
            if Directions.REVERSE[heading] in legal and isInDanger != Directions.REVERSE[heading]:
                action = Directions.REVERSE[heading]
            elif Directions.LEFT[heading] in legal and isInDanger != Directions.LEFT[heading]:
                action = Directions.LEFT[heading]
            elif Directions.RIGHT[heading] in legal and isInDanger != Directions.RIGHT[heading]:
                action = Directions.RIGHT[heading]
            elif heading in legal:
                action = heading  # if no other legal moves we continue to danger
            else:
                action = Directions.STOP  # cant move anywhere
        # if pacman is not in danger we proceed with regular leftturnagent
        else:
            # Turn left if possible
            left = Directions.LEFT[heading]  # What is left based on current heading
            if left in legal:
                action = left
            else:
                # No left turn
                if heading in legal:
                    action = heading  # continue in current direction
                elif Directions.RIGHT[heading] in legal:
                    action = Directions.RIGHT[heading]  # Turn right
                elif Directions.REVERSE[heading] in legal:
                    action = Directions.REVERSE[heading]  # Turn around
                else:
                    action = Directions.STOP  # Can't move!

        return action
