package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];	
	
	UtilityTool uTool = new UtilityTool();		
	BufferedImage mapImage;
	
	int mapWidth;
	int mapHeight;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[300];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTitleImage();
		//loadMap("/maps/world01.txt");
		loadMap("/maps/central2.txt");
		loadMapImage();
		
	}
	
	public void getTitleImage() {
		setup(0, "grass1", false);
		setup(1, "wall1", true);
		setup(2, "water1", true);
		setup(3, "earth1", false);
		setup(4, "tree1", true);
		setup(5, "sand1", false);	
		
		setup(6, "grass00", false);	
		setup(7, "grass00", false);	
		setup(8, "grass00", false);	
		setup(9, "grass00", false);
		
		setup(10, "grass00", false);	
		setup(11, "grass01", false);	
		setup(12, "water00", true);	
		setup(13, "water01", true);	
		setup(14, "water02", true);	
		setup(15, "water03", true);	
		setup(16, "water04", true);	
		setup(17, "water05", true);	
		setup(18, "water06", true);	
		setup(19, "water07", true);	
		setup(20, "water08", true);	
		setup(21, "water09", true);	
		setup(22, "water10", true);	
		setup(23, "water11", true);
		setup(24, "water12", true);	
		setup(25, "water13", true);	
		setup(26, "road00", false);	
		setup(27, "road01", false);
		setup(28, "road02", false);	
		setup(29, "road03", false);	
		setup(30, "road04", false);	
		setup(31, "road05", false);	
		setup(32, "road06", false);	
		setup(33, "road07", false);	
		setup(34, "road08", false);	
		setup(35, "road09", false);	
		setup(36, "road10", false);	
		setup(37, "road11", false);	
		setup(38, "road12", false);	
		setup(39, "earth", false);	
		setup(40, "wall", true);	
		setup(41, "tree", true);	
		
		
		setup2(100, "banqueta_top", false);	
		setup2(101, "banqueta_down", false);	
		setup2(102, "banqueta_left", false);	
		setup2(103, "banqueta_right", false);	
		setup2(104, "banqueta_full", false);	
		setup2(105, "banqueta_esquina_izq_down", false);	
		setup2(106, "banqueta_esquina_izq_top", false);	
		setup2(107, "banqueta_esquina_der_down", false);	
		setup2(108, "banqueta_esquina_der_top", false);
		setup2(109, "banqueta_esquina_izq_down2", false);	
		setup2(110, "banqueta_esquina_izq_top2", false);
		setup2(111, "banqueta_esquina_der_down2", false);	
		setup2(112, "banqueta_esquina_der_top2", false);	
		setup2(113, "banqueta_ambos", false);
		setup2(114, "cemento_full", false);
		setup2(115, "banqueta_x", false);
		setup2(116, "banqueta_esquina_der", false);
		setup2(117, "banqueta_esquina_izq", false);
		setup2(118, "banqueta_esquina_top", false);
		setup2(119, "banqueta_esquina_down", false);
		setup2(120, "banqueta_3_pasos_izq", false);
		setup2(121, "banqueta_3_pasos_der", false);
		setup2(122, "banqueta_3_pasos_top", false);
		setup2(123, "banqueta_3_pasos_down", false);
		setup2(124, "banqueta_esquinas_top", false);
		setup2(125, "banqueta_esquinas_left", false);
		setup2(126, "banqueta_esquinas_right", false);
		setup2(127, "banqueta_esquina_peq_izq", false);
		setup2(128, "banqueta_esquina_peq_der", false);
		setup2(129, "banqueta_esquina_peq_izq2", false);
		setup2(130, "banqueta_esquina_peq_der2", false);
		setup2(131, "banqueta_amarilla_y", false);
		setup2(132, "banqueta_amarilla_x", false);
		
		setup2(133, "cristal_right", true);
		setup2(134, "cristal_right2", true);
		setup2(135, "cristal_left2", true);
		setup2(136, "cristal", true);
		setup2(137, "cristal2", true);
		setup2(138, "cristal_right_top", true);
		setup2(151, "cristal_left_top", true);
		setup2(152, "cristal_top", true);
		setup2(153, "cristal_top2", true);
		setup2(154, "cristal_right_top2", true);
		setup2(155, "cristal_left_top2", true);
		setup2(156, "cristal_top3", true);
		setup2(160, "cristal_top4", true);
		setup2(164, "cristal_top5", true);
		
		setup2(139, "pared_gris_left", true);
		
		setup2(140, "pared_blanca_left", true);
		setup2(141, "pared_blanca_right", true);
		setup2(142, "pared_blanca", true);
		setup2(157, "pared_blanca_top", true);
		setup2(158, "pared_blanca_right_top", true);
		setup2(159, "pared_blanca_right2", true);
		setup2(161, "pared_blanca_top_left", true);
		setup2(162, "pared_blanca_left2", true);
		setup2(163, "pared_blanca_left_top", true);
		setup2(165, "pared_blanca_top_right", true);
		
		setup2(143, "cemento_full", false);	
		setup2(144, "cemento_amarillas_x", false);	
		setup2(145, "cemento_amarillas_y", false);	

		
		setup2(146, "cemento_full", true);
		setup2(147, "banqueta_left", true);		
		setup(148, "grass01", true);
		setup2(149, "banqueta_down", true);
		
		setup2(166, "gris", true);
		
		setup2(167, "tienda1", true);
		setup2(168, "tienda2", true);
		setup2(169, "tienda3", true);
		setup2(170, "tienda4", true);
		setup2(171, "tienda5", true);
		setup2(172, "tienda6", true);
		setup2(173, "tienda7", true);
		setup2(174, "tienda8", true);
		setup2(175, "tienda9", true);
		setup2(176, "tienda10", true);
		setup2(177, "tienda11", true);
		setup2(178, "tienda12", true);
		setup2(179, "tienda13", true);
		setup2(180, "tienda14", true);
		setup2(181, "tienda15", true);
		setup2(182, "tienda16", true);
		setup2(183, "tienda17", true);
		setup2(184, "tienda18", true);
		setup2(185, "tienda19", true);
		setup2(186, "tienda20", true);
		setup2(187, "tienda21", true);
		setup2(188, "tienda22", true);
		setup2(189, "tienda23", true);
		
		setup2(190, "tienda_azul1", true);
		setup2(191, "tienda_azul2", true);
		setup2(192, "tienda_azul3", true);
		setup2(193, "tienda_azul4", true);
		setup2(194, "tienda_azul5", true);
		setup2(195, "tienda_azul6", true);
		setup2(196, "tienda_azul7", true);
		setup2(197, "tienda_azul8", true);
		setup2(198, "tienda_azul9", true);
		setup2(199, "tienda_azul10", true);
		setup2(200, "tienda_azul11", true);
		setup2(201, "tienda_azul12", true);
		setup2(202, "tienda_azul13", true);
		
		setup2(203, "local1", true);
		setup2(204, "local2", true);
		setup2(205, "local3", true);
		setup2(206, "local4", true);
		setup2(207, "local5", true);
		setup2(208, "local6", true);
		setup2(209, "local7", true);
		setup2(210, "local8", true);
		setup2(211, "local9", true);
		setup2(212, "local10", true);
		
		setup2(213, "local_esquina_1", true);
		setup2(214, "local_esquina_2", true);
		setup2(215, "local_esquina3", true);
		setup2(216, "local_esquina4", true);
		setup2(217, "local_esquina5", true);
		setup2(218, "local_esquina6", true);
		setup2(219, "local_esquina7", true);
		setup2(220, "local_esquina8", true);
		setup2(221, "local_esquina9", true);
		setup2(222, "local_esquina10", true);
		setup2(223, "local_esquina11", true);
		setup2(224, "local_esquina12", true);
		setup2(225, "local_esquina13", true);
		setup2(226, "local_esquina14", true);
		setup2(227, "local_esquina15", true);
		setup2(228, "local_esquina16", true);
		setup2(229, "local_esquina17", true);
		setup2(230, "local_esquina18", true);
		setup2(231, "local_esquina19", true);
		setup2(232, "local_esquina20", true);
		setup2(233, "local_esquina21", true);
		setup2(234, "local_esquina22", true);
		setup2(235, "local_esquina23", true);
		setup2(236, "local_esquina24", true);
		setup2(237, "local_esquina25", true);
		setup2(238, "local_esquina26", true);
		setup2(239, "local_esquina27", true);
		setup2(240, "local_esquina28", true);
		setup2(241, "local_esquina29", true);
		setup2(242, "local_esquina30", true);
		setup2(243, "local_esquina31", true);
		setup2(244, "local_esquina32", true);
		setup2(245, "local_esquina33", true);
		setup2(246, "local_esquina_34", true);
		setup2(247, "local_esquina_35", true);
		setup2(248, "local_esquina_36", true);
		setup2(249, "local_esquina_37", true);
		setup2(250, "local_esquina_38", true);
		setup2(257, "local_esquina_39", true);
		setup2(258, "local_esquina_40", true);
		
		setup2(251, "techo_top", true);
		setup2(252, "techo_down", true);
		setup2(253, "techo_right", true);
		setup2(255, "techo_vuelta", true);
		setup2(256, "techo_top2", true);
		
		setup2(254, "jardinera", true);
		
		setup(150, "grass01", false);
	}
	
	public void setup(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imageName +".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setup2(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles2/"+ imageName +".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;					
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {			
		int worldCol = 0;
		int worldRow = 0;
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize*2 < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize*2 < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);			
				
			}			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}			
	}	
	
	public void loadMapImage() {
	    try {
	        mapImage = ImageIO.read(
	            getClass().getResourceAsStream("/menus/central2.png")
	        );
	   
	        mapWidth = gp.maxWorldCol * gp.tileSize;
	        mapHeight = gp.maxWorldRow * gp.tileSize;

	        mapImage = uTool.scaleImage(mapImage, mapWidth, mapHeight);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void drawMap(Graphics2D g2) {

	    int srcX = gp.player.worldX - gp.player.screenX;
	    int srcY = gp.player.worldY - gp.player.screenY;

	    // Evitar salirnos de la imagen
	    srcX = Math.max(0, Math.min(srcX, mapWidth - gp.screenWidth));
	    srcY = Math.max(0, Math.min(srcY, mapHeight - gp.screenHeight));

	    g2.drawImage(
	        mapImage,

	        // DESTINO (pantalla)
	        0,
	        0,
	        gp.screenWidth,
	        gp.screenHeight,

	        // ORIGEN (imagen)
	        srcX,
	        srcY,
	        srcX + gp.screenWidth,
	        srcY + gp.screenHeight,

	        null
	    );
	}

}
