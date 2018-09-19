package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_50_50() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePass_Quality_14_15() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 25, 14));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(15, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePass_Quality_14_16() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 14));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(16, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePass_Quality_14_17() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 14));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(17, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePass_Quality_14_0() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 14));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_Unchanged() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(0, itemSulfuras.getSellIn());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_Unchanged() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//Act
		store.updateEndOfDay();
		
		//DIE, INSECT
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Vial_Quality_15_14() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Vial of the Sands", 10, 15));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVial = items.get(0);
		assertEquals(14, itemVial.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Vial_Quality_15_13() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Vial of the Sands", -5, 15));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVial = items.get(0);
		assertEquals(13, itemVial.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Vial_Quality_0_0() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Vial of the Sands", 15, 0));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVial = items.get(0);
		assertEquals(0, itemVial.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Vial_SellIn_8_7() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Vial of the Sands", 8, 13));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVial = items.get(0);
		assertEquals(7, itemVial.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Vial_QualityNegative() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Vial of the Sands", 8, -500)); //A pretty bad vial, who would even buy this?
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVial = items.get(0);
		assertEquals(-500, itemVial.getQuality());
		
	}
	
}
