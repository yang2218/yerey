package com.minimalabs.yerey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TerrainPanel extends JPanel {

   private TerrainGenerator terrainGenerator;
   private TerrainRenderer renderer;

   public TerrainPanel(TerrainGenerator terrainGenerator, TerrainRenderer renderer) {
      setTerrainGenerator(terrainGenerator);
      this.renderer = renderer;
      reset();
   }

   public void reset() {
      Dimension size = terrainGenerator.getSize();
      setMinimumSize(size);
      setPreferredSize(size);
   }
   
   public TerrainGenerator getTerrainGenerator() {
      return terrainGenerator;
   }

   public void setTerrainGenerator(TerrainGenerator terrainGenerator) {
      this.terrainGenerator = terrainGenerator;
   }

   public void paint(Graphics g) {
      Terrain terrain = terrainGenerator.getTerrain();
      Dimension size = terrain.getSize();
      Color color;
      for (int x = 0; x < size.width; x++) {
         for (int y = 0; y < size.height; y++) {
            double value = terrain.get(x,y);
            color = renderer.render(value);
            g.setColor(color);
            g.fillRect(x, y, 1, 1);
         }
      }
   }

   
}
