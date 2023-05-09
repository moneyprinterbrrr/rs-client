package api.actor;

import accessors.RSPlayer;
import runestar.generated.XPlayer;
import api.actor.ActorWrapper;
import api.actor.NpcWrapper;

public class PlayerWrapper extends ActorWrapper {
    private final RSPlayer rsPlayer;

    public PlayerWrapper(RSPlayer rsPlayer) {
        super(rsPlayer);
        this.rsPlayer = rsPlayer;
    }

    @Override
    public int getPlane() {
        return rsPlayer.getPlane();
    }
//
////    public Username getName() {
////        return rsPlayer.getUsername() != null ? new Username(accessor.getUsername()) : null;
////    }
//    //TODO
//
//    public List<String> getActions() {
//        return Arrays.stream(rsPlayer.getActions()).toList();
//    }
//
//    public int getCombatLevel() {
//        return rsPlayer.getCombatLevel();
//    }
//
//    public int getHeadIconPrayer() {
//        return rsPlayer.getHeadIconPrayer();
//    }
//
//    public int getHeadIconPk() {
//        return rsPlayer.getHeadIconPk();
//    }
//
//    public int getTeam() {
//        return rsPlayer.getTeam();
//    }
//
//    //TODO
////    public PlayerAppearance getAppearance() {
////        return rsPlayer.getAppearance() != null ? new PlayerAppearance(accessor.getAppearance()) : null;
////    }
//
//    public static int combatLevel(int attack, int strength, int defence, int ranged, int prayer, int magic, int hitpoints) {
//        int base = defence + hitpoints + prayer / 2;
//        int offenseMelee = attack + strength;
//        int offenseRanged = 3 * ranged / 2;
//        int offenseMagic = 3 * magic / 2;
//        int offense = Math.max(offenseMelee, Math.max(offenseRanged, offenseMagic));
//        return (base + 13 * offense / 10) / 4;
//    }
}