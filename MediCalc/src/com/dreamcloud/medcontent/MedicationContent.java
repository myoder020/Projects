package com.dreamcloud.medcontent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;

public class MedicationContent {
	
	/**
	 * An array of sample (Medication) items.
	 */
	public static List<MedicationItem> ITEMS = new ArrayList<MedicationItem>();

	/**
	 * A map of sample (Medication) items, by ID.
	 */
	public static Map<String, MedicationItem> ITEM_MAP = new HashMap<String, MedicationItem>();

	static {
		// Add 9 items.
		addItem(new MedicationItem("1", "Acetaminophen", "Tylenol, FeverAll, Anacin, Vicks 44", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("2", "Adenosine", "Adenocard, Adenoscan", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("3", "Albuterol", "Proventil, Ventolin", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("4", "Amiodarone", "Cordarone, Pacerone", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("5", "Aspirin", "Bayer / Ecotrin / Bufferin / Anacin / Excedrin", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("6", "Atropine Sulfate", "Atropine", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("7", "Calcium Chloride / Gluconate", "", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("8", "Dextrose", "D50, D25, D10", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("9", "Diltiazem", "Cardizem, Cartia, Dilacor, Dilt, Diltia, Taztia, Tiazac", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("10", "Diphenhydramine", "Benadryl, Unisom, Sominex, Nytol", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("12", "Dopamine", "Inotropin, Pressor", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("13", "Epinephrine", "", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("14", "Etomidate", "Amidate", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("15", "Fentanyl", "Sublimaze, Duragesic", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("16", "Furosemide", "", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("17", "Glucagon", "Glucagon", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("18", "Glucose Gel (Oral)", "Glutose, Insta-Glucose", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("19", "Ketamine", "Ketalar", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("20", "Lidocaine", "Xylocaine", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("21", "Magnesium Sulfate", "", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("22", "Methylprednisolone", "Solu-Medrol", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("23", "Metoprolol", "Lopressor, Toprol", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("24", "Midazolam", "Versed", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("25", "Morphine Sulfate", "Astramorph, Duramorph, MS Contin, Oramorph SR", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("26", "Naloxone", "Narcan", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("27", "Nitroglycerin for Infusion", "", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("28", "Nitroglycerin", "Nitro-bid, Nitro-dur", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("29", "Norepinephrine Bitartrate", "Levophed", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("30", "Olanzapine", "Zyprexa, Zyprexa ODT", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("31", "Ondansetron", "Zofran, Zofran ODT", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("32", "Oxymetazoline", "Afrin", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("33", "Prednisone", "Prednisone Intensol, Sterapred, Deltasone", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("34", "Procainamide HCL", "Procan SR, Pronestyl", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("35", "Sodium Bicarbonate", "Baking Soda, Citrocarbonate, Neut", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("36", "Succinylcholine", "Anectine", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("37", "Vasopressin", "Pitressin", "Adult Dosing, Pediatric Dosing"));
		addItem(new MedicationItem("38", "Diazepam (Valium)", "", "Adult Dosing, Pediatric Dosing"));
	}

	private static void addItem(MedicationItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
	
	public static String getItemName(int index){
		return ITEMS.get(index).name; 
	}

    public static String getItemType(int index){
        return ITEMS.get(index).type;
    }
	
	public static String getItemDescription(int index){
		return ITEMS.get(index).description;
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class MedicationItem {
		public String id;
		public String name;
		public String type;
		public String description;

		public MedicationItem(String id, String name, String type, String description) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.description = description;
		}

		@Override
		public String toString() {
			return name;
		}
		
	}

	
}
