package znick_.riskofrain2.item;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import znick_.riskofrain2.api.ror.survivor.Survivor;
import znick_.riskofrain2.item.armor.ArmorPiece;
import znick_.riskofrain2.item.armor.ArmorType;
import znick_.riskofrain2.item.ror.RiskOfRain2Item;
import znick_.riskofrain2.item.ror.dlc.survivorsofthevoid.voiditems.pluripotentlarva.PluripotentLarvaItem;
import znick_.riskofrain2.item.ror.dlc.survivorsofthevoid.voiditems.saferspaces.SaferSpacesItem;
import znick_.riskofrain2.item.ror.dlc.survivorsofthevoid.voiditems.weepingfungus.WeepingFungusItem;
import znick_.riskofrain2.item.ror.list.ScrapItem;
import znick_.riskofrain2.item.ror.list.boss.pearl.PearlItem;
import znick_.riskofrain2.item.ror.list.boss.titanicknurl.TitanicKnurlItem;
import znick_.riskofrain2.item.ror.list.equipment.BlastShowerItem;
import znick_.riskofrain2.item.ror.list.equipment.ForeignFruitItem;
import znick_.riskofrain2.item.ror.list.equipment.RiskOfRain2Equipment;
import znick_.riskofrain2.item.ror.list.equipment.elite.EliteEquipmentItem;
import znick_.riskofrain2.item.ror.list.equipment.elite.herbitingembrace.HerBitingEmbraceItem;
import znick_.riskofrain2.item.ror.list.equipment.elite.ifritsdistinction.IfritsDistinctionItem;
import znick_.riskofrain2.item.ror.list.equipment.elite.nkuhanasretort.NkuhanasRetortItem;
import znick_.riskofrain2.item.ror.list.equipment.jadeelephant.JadeElephantItem;
import znick_.riskofrain2.item.ror.list.equipment.ocularhud.OcularHudItem;
import znick_.riskofrain2.item.ror.list.equipment.supermassiveleech.SuperMassiveLeechItem;
import znick_.riskofrain2.item.ror.list.green.Chronobauble;
import znick_.riskofrain2.item.ror.list.green.FuelCell;
import znick_.riskofrain2.item.ror.list.green.HarvestersScythe;
import znick_.riskofrain2.item.ror.list.green.HopooFeather;
import znick_.riskofrain2.item.ror.list.green.LeechingSeed;
import znick_.riskofrain2.item.ror.list.green.WaxQuail;
import znick_.riskofrain2.item.ror.list.green.WillOTheWisp;
import znick_.riskofrain2.item.ror.list.green.atgmissile.ATGMissileItem;
import znick_.riskofrain2.item.ror.list.green.huntersharpoon.HuntersHarpoonItem;
import znick_.riskofrain2.item.ror.list.green.infusion.InfusionItem;
import znick_.riskofrain2.item.ror.list.green.oldwarstealthkit.OldWarStealthkit;
import znick_.riskofrain2.item.ror.list.green.redwhip.RedWhipItem;
import znick_.riskofrain2.item.ror.list.green.regeneratingscrap.RegeneratingScrapConsumedItem;
import znick_.riskofrain2.item.ror.list.green.regeneratingscrap.RegeneratingScrapItem;
import znick_.riskofrain2.item.ror.list.green.rosebuckler.RoseBucklerItem;
import znick_.riskofrain2.item.ror.list.green.warhorn.WarHornItem;
import znick_.riskofrain2.item.ror.list.lunar.BeadsOfFealty;
import znick_.riskofrain2.item.ror.list.lunar.Purity;
import znick_.riskofrain2.item.ror.list.lunar.ShapedGlass;
import znick_.riskofrain2.item.ror.list.red.AlienHead;
import znick_.riskofrain2.item.ror.list.red.HardlightAfterburner;
import znick_.riskofrain2.item.ror.list.red.HeadSet;
import znick_.riskofrain2.item.ror.list.red.RejuvinationRack;
import znick_.riskofrain2.item.ror.list.red.bensraincoat.BensRaincoatItem;
import znick_.riskofrain2.item.ror.list.red.brilliantbehemoth.BrilliantBehemothItem;
import znick_.riskofrain2.item.ror.list.red.ceremonialdagger.CeremonialDaggerItem;
import znick_.riskofrain2.item.ror.list.red.defensivemicrobots.DefensiveMicrobotsItem;
import znick_.riskofrain2.item.ror.list.red.diosbestfriend.DiosBestFriendConsumed;
import znick_.riskofrain2.item.ror.list.red.diosbestfriend.DiosBestFriendItem;
import znick_.riskofrain2.item.ror.list.red.fiftysevenleafclover.FiftySevenLeafClover;
import znick_.riskofrain2.item.ror.list.white.BisonSteak;
import znick_.riskofrain2.item.ror.list.white.Crowbar;
import znick_.riskofrain2.item.ror.list.white.FocusCrystal;
import znick_.riskofrain2.item.ror.list.white.Gasoline;
import znick_.riskofrain2.item.ror.list.white.MonsterTooth;
import znick_.riskofrain2.item.ror.list.white.RepulsionArmorPlate;
import znick_.riskofrain2.item.ror.list.white.RustedKey;
import znick_.riskofrain2.item.ror.list.white.SoldierSyringe;
import znick_.riskofrain2.item.ror.list.white.TriTipDagger;
import znick_.riskofrain2.item.ror.list.white.armorpiercingrounds.ArmorPiercingRoundsItem;
import znick_.riskofrain2.item.ror.list.white.bustlingfungus.BustlingFungusItem;
import znick_.riskofrain2.item.ror.list.white.cautiousslug.CautiousSlugItem;
import znick_.riskofrain2.item.ror.list.white.critglasses.CritGlassesItem;
import znick_.riskofrain2.item.ror.list.white.delicatewatch.BrokenDelicateWatchItem;
import znick_.riskofrain2.item.ror.list.white.delicatewatch.DelicateWatchItem;
import znick_.riskofrain2.item.ror.list.white.energydrink.EnergyDrinkItem;
import znick_.riskofrain2.item.ror.list.white.fireworks.FireworksItem;
import znick_.riskofrain2.item.ror.list.white.goathoof.GoatHoofItem;
import znick_.riskofrain2.item.ror.list.white.medkit.MedkitItem;
import znick_.riskofrain2.item.ror.list.white.mocha.MochaItem;
import znick_.riskofrain2.item.ror.list.white.oddlyshapedopal.OddlyShapedOpalItem;
import znick_.riskofrain2.item.ror.list.white.personalshieldgenerator.PersonalShieldGeneratorItem;
import znick_.riskofrain2.item.ror.list.white.powerelixir.EmptyBottleItem;
import znick_.riskofrain2.item.ror.list.white.powerelixir.PowerElixirItem;
import znick_.riskofrain2.item.ror.list.white.rollofpennies.RollOfPenniesItem;
import znick_.riskofrain2.item.ror.list.white.stungrenade.StunGrenadeItem;
import znick_.riskofrain2.item.ror.list.white.topazbrooch.TopazBroochItem;
import znick_.riskofrain2.item.ror.list.white.toughertimes.TougherTimesItem;
import znick_.riskofrain2.item.ror.list.white.warbanner.WarbannerItem;
import znick_.riskofrain2.item.ror.property.CustomRarity;
import znick_.riskofrain2.item.ror.property.ItemRarity;
import znick_.riskofrain2.util.creativetabs.RiskOfRain2CreativeTabs;

public class RiskOfRain2Items {
	
	/**
	 * The set of all items in the Risk Of Rain 2 game. Special items such as consumed items or command
	 * essence are not included here, only standard items that would be included in the logbook. Specifically,
	 * the following types of items are not included in this set:
	 * 
	 * <ul>
	 *	<li>Command essences such as {@link #WHITE_COMMAND_ESSENCE}
	 *	<li>Elite equipment items such as {@link #IFRITS_DISTINCTION}
	 *	<li>Consumed items such as {@link #BROKEN_DELICATE_WATCH}
	 * </ul>
	 * 
	 * In general, this set is exactly equal to the set of items shown in the logbook. 
	 */
	private static final Set<RiskOfRain2Item> ITEM_SET = new LinkedHashSet<RiskOfRain2Item>();
	
	public static final Item HUNTRESS_HELMET = new ArmorPiece(Survivor.HUNTRESS, ArmorType.HELMET, "huntress");
	public static final Item HUNTRESS_CHESTPLATE = new ArmorPiece(Survivor.HUNTRESS, ArmorType.CHESTPLATE, "huntress");
	public static final Item HUNTRESS_LEGGINGS = new ArmorPiece(Survivor.HUNTRESS, ArmorType.LEGGINGS, "huntress");
	public static final Item HUNTESS_BOOTS = new ArmorPiece(Survivor.HUNTRESS, ArmorType.BOOTS, "huntress");
	
	public static final Item RAW_HUNTRITE = new BasicItem("Raw Huntrite", "character/huntress/", RiskOfRain2CreativeTabs.MISC, CustomRarity.RED);
	public static final Item HUNTRITE_PLATE = new BasicItem("Huntrite Plate", "character/huntress/", RiskOfRain2CreativeTabs.MISC, CustomRarity.RED);
	public static final Item TRESSIUM_PLATE = new BasicItem("Tressium Plate", "character/huntress/", RiskOfRain2CreativeTabs.MISC, CustomRarity.DARK_BLUE);
	public static final Item LENS_FRAME = new BasicItem("Lens Frame", "character/huntress/", RiskOfRain2CreativeTabs.MISC);
	public static final Item LENS = new BasicItem("Lens", "character/huntress", RiskOfRain2CreativeTabs.MISC);
	public static final Item LIGHT_BLUE_LENS = new BasicItem("Light Blue Lens", "character/huntress", RiskOfRain2CreativeTabs.MISC);
	public static final Item LIGHT_BLUE_FRAMED_LENS = new BasicItem("Light Blue Framed Lens", "character/huntress", RiskOfRain2CreativeTabs.MISC);
	public static final Item LIGHT_BLUE_FRAMED_LENS_PAIR = new BasicItem("Light Blue Framed Lens Pair", "character/huntress", RiskOfRain2CreativeTabs.MISC, EnumRarity.rare);
	
	/**
	 * The "repulsion armor plate" item. Each time the player is hurt, they take 1 (+1 per item) half-heart less
	 * damage.
	 */
	public static final RiskOfRain2Item REPULSION_ARMOR_PLATE = new RepulsionArmorPlate();
	
	/**
	 * The "mocha" item. Increases movement speed by 7% per stack. 
	 */
	public static final RiskOfRain2Item MOCHA = new MochaItem();
	
	/**
	 * The "topaz brooch" item. Upon killing an enemy, the player gains barrier. 
	 */
	public static final RiskOfRain2Item TOPAZ_BROOCH = new TopazBroochItem();
	/**
	 * The "tougher times" item. Gives the player a 15% (+15% per item) chance to take no damage upon getting hurt.
	 * Stacks hyperbolically instead of linearly, meaning it is impossible to reach 100% block chance. 
	 */
	public static final RiskOfRain2Item TOUGHER_TIMES = new TougherTimesItem();
	/**
	 * The "tri-tip dagger" item. Gives the player a 15% (+15% per item) chance per hit to apply wither 2 to
	 * the attacked enemy for 5 seconds.
	 */
	public static final RiskOfRain2Item TRI_TIP_DAGGER = new TriTipDagger();
	/**
	 * The "armor piercing rounds" item. Causes the player to deal 20% (+20% per item) more damage to bosses,
	 * such as the Ender Dragon or the Wither. May not work on modded bosses depending on how they are coded. 
	 */
	public static final RiskOfRain2Item ARMOR_PIERCING_ROUNDS = new ArmorPiercingRoundsItem();
	/**
	 * The "Len's-Maker Glasses" item. Adds a 10% chance (+10% per item) for an attack to land a critical hit, 
	 * dealing double damage. 
	 */
	public static final RiskOfRain2Item CRIT_GLASSES = new CritGlassesItem();
	/**
	 * The "crowbar" item. Activates when the player attacks an enemy with over 90% health. The hit will deal
	 * 75% (+75% per item) more damage. 
	 */
	public static final RiskOfRain2Item CROWBAR = new Crowbar();
	
	public static final RiskOfRain2Item BUNDLE_OF_FIREWORKS = new FireworksItem();
	
	public static final RiskOfRain2Item BISON_STEAK = new BisonSteak();
	
	/**
	 * The "Delicate Watch" item. Gives the player +20% damage, but breaks if the player falls below 25% health.
	 */
	public static final RiskOfRain2Item DELICATE_WATCH = new DelicateWatchItem();
	/**
	 * The broken form of the {@link #DELICATE_WATCH} item that's given after the delicate watch breaks.
	 * Does nothing.
	 */
	public static final RiskOfRain2Item BROKEN_DELICATE_WATCH = new BrokenDelicateWatchItem();
	
	public static final RiskOfRain2Item ROLL_OF_PENNIES = new RollOfPenniesItem();
	
	/**
	 * The "cautious slug" item. Activates when the player does not take damage for 7 seconds. Begins healing the
	 * player at a rate of 1 (/2 per item) second per half-heart. Deactivates when the player takes damage.
	 */
	public static final RiskOfRain2Item CAUTIOUS_SLUG = new CautiousSlugItem();
	
	public static final RiskOfRain2Item POWER_ELIXIR = new PowerElixirItem();
	public static final RiskOfRain2Item EMPTY_BOTTLE = new EmptyBottleItem();
	/**
	 * The "Paul's goat hoof" item. Adds 14% (+14% per item) boost to movement speed.
	 */
	public static final RiskOfRain2Item PAULS_GOAT_HOOF = new GoatHoofItem();
	
	/**
	 * The "gasoline" item. When the player kills an enemy, all enemies around the killed enemy are lit on fire
	 * in a radius of 5 (+1 per item) blocks. The enemies are lit for 2 (+1 per item) seconds. 
	 */
	public static final RiskOfRain2Item GASOLINE = new Gasoline();
	/**
	 * The "medkit" item. Heals the player 2 seconds after they take damage for 2 (+1 per item) hearts.
	 */
	public static final RiskOfRain2Item MEDKIT = new MedkitItem();
	public static final RiskOfRain2Item BUSTLING_FUNGUS = new BustlingFungusItem();
	/**
	 * The "focus crystal" item. Causes the player to deal 20% (+20% per stack) more damage to enemies within 
	 * 4 blocks of the player.
	 */
	public static final RiskOfRain2Item FOCUS_CRYSTAL = new FocusCrystal();
	public static final RiskOfRain2Item ODDLY_SHAPED_OPAL = new OddlyShapedOpalItem();
	public static final RiskOfRain2Item PERSONAL_SHIELD = new PersonalShieldGeneratorItem();
	/**
	 * The "white scrap" item. Does nothing, but is taken first when using white 3D printers.
	 */
	public static final RiskOfRain2Item WHITE_SCRAP = new ScrapItem(ItemRarity.WHITE);
	/**
	 * The "energy drink" item. Adds 25% (+25% per item) movement speed to the player while sprinting.
	 */
	public static final RiskOfRain2Item ENERGY_DRINK = new EnergyDrinkItem();
	/**
	 * The "stun grenade" item. Has a 5% (+5% per item) chance to stun enemies in place for 2 seconds. 
	 */
	public static final RiskOfRain2Item STUN_GRENADE = new StunGrenadeItem();
	public static final RiskOfRain2Item SOLDIER_SYRINGE = new SoldierSyringe();
	/**
	 * The "monster tooth" item. The player is healed when consuming XP.
	 */
	public static final RiskOfRain2Item MONSTER_TOOTH = new MonsterTooth();
	/**
	 * The "rusted key" item. Allows the player to open rusty lockboxes.
	 */
	public static final RiskOfRain2Item RUSTED_KEY = new RustedKey();
	public static final RiskOfRain2Item WAR_BANNER = new WarbannerItem();
	
	public static final RiskOfRain2Item WAR_HORN = new WarHornItem();
	public static final RiskOfRain2Item FUEL_CELL = new FuelCell();
	/**
	 * The "will-o-the wisp" item. When an enemy dies, it explodes.
	 */
	public static final RiskOfRain2Item WILL_O_THE_WISP = new WillOTheWisp();
	/**
	 * The "hopoo feather" item. Allows the player 1 (+1 per stack) extra jump while mid-air.
	 */
	public static final RiskOfRain2Item HOPOO_FEATHER = new HopooFeather();
	/**
	 * The "harvesters scythe" item. When the player lands a critical attack, The player is healed 1 heart
	 * (+1 per item).
	 */
	public static final RiskOfRain2Item HARVESTERS_SCYTHE = new HarvestersScythe();
	public static final RiskOfRain2Item INFUSION = new InfusionItem();
	/**
	 * The "wax quail" item. Boosts the player forward when jumping while springing.
	 */
	public static final RiskOfRain2Item WAX_QUAIL = new WaxQuail();
	public static final RiskOfRain2Item ATG_MISSILE = new ATGMissileItem();
	public static final RiskOfRain2Item HUNTERS_HARPOON = new HuntersHarpoonItem();
	/**
	 * The "old war stealthkit" item. Falling below 25% health causes the player to become invisible and gain
	 * 40% movement speed for 5 seconds. Recharges every 30 seconds (-50% per item).
	 */
	public static final RiskOfRain2Item OLD_WAR_STEALTHKIT = new OldWarStealthkit();
	public static final RiskOfRain2Item REGENERATING_SCRAP = new RegeneratingScrapItem();
	public static final RiskOfRain2Item REGENERATING_SCRAP_CONSUMED = new RegeneratingScrapConsumedItem();
	/**
	 * The "green scrap" item. Does nothing, but is taken first when using green 3D printers.
	 */
	public static final RiskOfRain2Item GREEN_SCRAP = new ScrapItem(ItemRarity.GREEN);
	/**
	 * The "leeching seed" item. Heals 1 (+1 per item) half hearts upon dealing damage.
	 */
	public static final RiskOfRain2Item LEECHING_SEED = new LeechingSeed();
	/**
	 * The "chronobauble" item. Gives enemies the slowness potion effect on hit. 
	 */
	public static final RiskOfRain2Item CHRONOBAUBLE = new Chronobauble();
	
	public static final RiskOfRain2Item ROSE_BUCKLER = new RoseBucklerItem();
	public static final RiskOfRain2Item RED_WHIP = new RedWhipItem();
	
	//Red Items
	public static final RiskOfRain2Item ALIEN_HEAD = new AlienHead();
	/**
	 * The "brilliant behemoth" item. All of the players attacks explode in a radius of 2 (+1 per item).
	 */
	public static final RiskOfRain2Item BRILLIANT_BEHEMOTH = new BrilliantBehemothItem();
	
	/**
	 * The "defensive microbots" item. Any projectiles coming towards the player are deleted with a 
	 * 0.5 second cooldown.
	 */
	public static final RiskOfRain2Item DEFENSIVE_MICROBOTS = new DefensiveMicrobotsItem();
	
	/**
	 * The "fifty-seven leaf clover" item. Increases the players luck stat by 1 per stat. 
	 */
	public static final RiskOfRain2Item FIFTY_SEVEN_LEAF_CLOVER = new FiftySevenLeafClover();
	
	/**
	 * The "ceremonial dagger" item. When the player kills an enemy, 3 homing daggers are shot at the
	 * location of the enemy's death. 
	 */
	public static final RiskOfRain2Item CEREMONIAL_DAGGER = new CeremonialDaggerItem();
	
	/**
	 * The "Dio's best friend" item. Allows the player to be saved from death followed by 10 seconds of
	 * invincibility. Consumed on use.
	 */
	public static final RiskOfRain2Item DIOS_BEST_FRIEND = new DiosBestFriendItem();
	public static final RiskOfRain2Item DIOS_BEST_FRIEND_CONSUMED = new DiosBestFriendConsumed();
	/**
	 * The "H3AD-5T v2" item. Makes the player jump significantly higher. 
	 */
	public static final RiskOfRain2Item HEAD_SET = new HeadSet();
	
	public static final RiskOfRain2Item BENS_RAINCOAT = new BensRaincoatItem();
	
	/**
	 * The "rejuvination rack" item. Adds 100% (+100% per stack) to all healing. 
	 */
	public static final RiskOfRain2Item REJUVINATION_RACK = new RejuvinationRack();
	/**
	 * The "red scrap" item. Does nothing, but is taken first when using red 3D printers.
	 */
	public static final RiskOfRain2Item RED_SCRAP = new ScrapItem(ItemRarity.RED);
	public static final RiskOfRain2Item HARDLIGHT_AFTERBURNER = new HardlightAfterburner();
	
	//Boss Items
	public static final RiskOfRain2Item PEARL = new PearlItem();
	public static final RiskOfRain2Item TITANIC_KNURL = new TitanicKnurlItem();
	public static final RiskOfRain2Item BOSS_SCRAP = new ScrapItem(ItemRarity.BOSS);
	
	// Void Items 
	public static final RiskOfRain2Item SAFER_SPACES = new SaferSpacesItem();
	public static final RiskOfRain2Item WEEPING_FUNGUS = new WeepingFungusItem();
	public static final RiskOfRain2Item PLURIPOTENT_LARVA = new PluripotentLarvaItem();
	
	//Lunar Items
	public static final RiskOfRain2Item SHAPED_GLASS = new ShapedGlass();
	public static final RiskOfRain2Item PURITY = new Purity();
	/**
	 * The "beads of fealty" item. Does nothing, but takes the player to the "A Moment, Whole" realm when ending the
	 * game. 
	 */
	public static final RiskOfRain2Item BEADS_OF_FEALTY = new BeadsOfFealty();	
	
	//Active Equipment Items
	public static final RiskOfRain2Equipment BLAST_SHOWER = new BlastShowerItem();
	public static final RiskOfRain2Equipment FOREIGN_FRUIT = new ForeignFruitItem();
	public static final RiskOfRain2Equipment SUPER_MASSIVE_LEECH = new SuperMassiveLeechItem();
	public static final RiskOfRain2Equipment JADE_ELEPHANT = new JadeElephantItem();
	public static final RiskOfRain2Equipment OCULAR_HUD = new OcularHudItem();
	
	public static final EliteEquipmentItem IFRITS_DISTINCTION = new IfritsDistinctionItem();
	public static final EliteEquipmentItem HER_BITING_EMBRACE = new HerBitingEmbraceItem();
	public static final EliteEquipmentItem NKUHANAS_RETORT = new NkuhanasRetortItem();
	
	/**
	 * Registers all items into the game.
	 */
	public static final void registerItems() {
		try {
			// Loop through all fields in this class
			for (Field field : RiskOfRain2Items.class.getDeclaredFields()) {
				
				// Check if it's an item
				if (field.get(null) instanceof Item) {
					
					//If it is, register it
					Item item = (Item) field.get(null);
					GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
					
					// Register items into the item set
					if (item instanceof RiskOfRain2Item) {
						RiskOfRain2Item rorItem = (RiskOfRain2Item) item;
						ITEM_SET.add(rorItem);
					}
				}
			}
		} catch(Exception e) {throw new RuntimeException(e);}
	}
	
	/**
	 * Returns the set of all Risk of Rain 2 items.
	 */
	public static RiskOfRain2Item[] itemSet() {
		return ITEM_SET.toArray(new RiskOfRain2Item[0]);
	}
	
	/**
	 * Returns a subset of the Risk of Rain 2 items that all match the given filters.
	 * 
	 * @param filters The filters on the item set
	 * 
	 * @return The filtered array of items
	 */
	public static RiskOfRain2Item[] itemSubset(Predicate<? super RiskOfRain2Item>... filters) {
		return ITEM_SET.stream().filter(item -> Arrays.stream(filters).allMatch(filter -> filter.test(item))).toArray(RiskOfRain2Item[]::new);
	}
}
