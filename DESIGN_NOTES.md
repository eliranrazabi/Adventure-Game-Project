Invariants: HP always stays between 0 and maxHP, and resource always stay betwen 0-10.
Combatants keeps these fields private. Also the methods that change HP or resource aren't public.

Reward Preconditions: A player can only recieve an award when it wins Encounter 1, and only if no reward has been claimed yet. Game stores this info in firstEncounterWom and rewardClaimed. claimReward checks these before changing anything. 

State Ownership:
Combatant: HP, max HP, resource, pending defense, attack damage, name.
Game: The player object, firstEncounterWon, rewardClaimed, and the order of the adventure.
Battle and reward dont own nothing.
