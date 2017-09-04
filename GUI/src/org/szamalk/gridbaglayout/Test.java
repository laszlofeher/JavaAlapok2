/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.szamalk.gridbaglayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Lenovo
 */
public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                ChessPieceMouseAdapter chessPieceMouseAdapter = new ChessPieceMouseAdapter() {
                    @Override
                    boolean chessPieceSelected(ChessPiece chessPiece, ChessboardBlock cb) {
                        System.out.println("From Location: " + chessPiece.getLocation()
                                + " Piece Type: " + chessPiece.getType()
                                + " Piece Color: " + chessPiece.getColor());
                        return true;
                    }

                    @Override
                    void chessPiecePlaced(ChessPiece chessPiece, ChessboardBlock cb) {
                        cb.setPiece(new ChessPiece(chessPiece.getImage(),
                                chessPiece.getType(),
                                cb.getBlockLocation(),
                                chessPiece.getColor()));

                        System.out.println("To Location: " + cb.getChessPiece().getLocation()
                                + " Piece Type: " + cb.getChessPiece().getType()
                                + " Piece Color: " + cb.getChessPiece().getColor());
                    }
                };

                Chessboard chessBoard = new Chessboard(chessPieceMouseAdapter);
                chessPieceMouseAdapter.setChessboard(chessBoard);//or else NPE will be thrown when press/drag/release on chessboard occurs

                BufferedImage knightImage = null;
                try {
                    knightImage = ImageIO.read(new URL("http://i.stack.imgur.com/qdppY.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChessPiece knightPiece = new ChessPiece(knightImage, "Knight", null, "White");//location parameter can be null or anything will be set if matching block is found
                chessBoard.setChessPiece("A1", knightPiece);

                NotationPanel rows = new NotationPanel(new String[]{"8", "7", "6", "5", "4", "3", "2", "1"}, NotationPanel.VERTICAL);
                NotationPanel cols = new NotationPanel(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"}, NotationPanel.HORIZONTAL);

                frame.add(rows, BorderLayout.WEST);
                frame.add(cols, BorderLayout.SOUTH);
                frame.add(chessBoard);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

class NotationPanel extends JPanel {

    final static String HORIZONTAL = "horizontal";
    final static String VERTICAL = "vertical";

    public NotationPanel(String[] strings, String direction) {
        if (direction.equals(VERTICAL)) {
            setLayout(new GridLayout(8, 0));
        } else {
            setLayout(new GridLayout(0, 8));
        }
        for (String string : strings) {
            this.add(new JLabel(string, JLabel.CENTER));
        }

    }
}

class Chessboard extends JPanel {

    private final ArrayList<ChessboardBlock> chessBoardBlocks;
    ChessPieceMouseAdapter chessPieceMouseAdapter;

    public Chessboard(ChessPieceMouseAdapter chessPieceMouseAdapter) {
        super(new GridLayout(8, 8));
        chessBoardBlocks = new ArrayList<>(64);
        layoutBoard();
        this.chessPieceMouseAdapter = chessPieceMouseAdapter;
        addMouseListener(this.chessPieceMouseAdapter);
        addMouseMotionListener(this.chessPieceMouseAdapter);
    }

    private void layoutBoard() {
        String[] cols = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        int[] rows = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int NUMBER_OF_BLOCKS = 64;
        String row, col;
        int rowCount = 7, colCount = 0, trigger = 8;

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            if (trigger == 0) {
                colCount = 0;
                trigger = 8;
                rowCount--;
            }
            col = cols[colCount++];
            row = String.valueOf(rows[rowCount]);
            trigger--;

            Color pieceHolderColor = ((rowCount + colCount) % 2 == 0 ? Color.WHITE : Color.BLACK);
            String pieceHolderLocation = col + row;

            ChessboardBlock pieceHolder = new ChessboardBlock(pieceHolderLocation, pieceHolderColor);
            pieceHolder.setPiece(null);

            add(pieceHolder);//add to the board
            chessBoardBlocks.add(pieceHolder);//add to piece holder array
        }
    }

    boolean setChessPiece(String location, ChessPiece piece) {
        for (int i = 0; i < chessBoardBlocks.size(); i++) {
            if (chessBoardBlocks.get(i).getBlockLocation().equalsIgnoreCase(location)) {
                chessBoardBlocks.get(i).setPiece(new ChessPiece(piece.getImage(),
                        piece.getType(), chessBoardBlocks.get(i).getBlockLocation(),
                        piece.getColor()));
                return true;
            }
        }
        return false;
    }

    public ArrayList<ChessboardBlock> getChessBoardBlocks() {
        return chessBoardBlocks;
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);

        if (chessPieceMouseAdapter.isDragging()) {
            if (chessPieceMouseAdapter.getDraggedPiece() != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                g2d.drawImage(chessPieceMouseAdapter.getDraggedPiece().getImage(),
                        chessPieceMouseAdapter.getDraggedPieceLocation().x, chessPieceMouseAdapter.getDraggedPieceLocation().y, this);
            }
        }
    }
}

class ChessboardBlock extends JLabel {

    private final Dimension labelDimensions = new Dimension(50, 50);
    private ChessPiece chessPiece;
    private String location;

    public ChessboardBlock(String location, Color backgroundColor) {
        //super(location,JLabel.CENTER);//puts location as text on label
        this.location = location;
        setBackground(backgroundColor);
        setOpaque(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return labelDimensions;
    }

    void setPiece(ChessPiece p) {
        this.chessPiece = p;
        if (chessPiece == null) {
            setIcon(null);
        } else if (chessPiece.getImage() != null) {
            setIcon(new ImageIcon(chessPiece.getImage()));
        }
    }

    String getBlockLocation() {
        return location;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }
}

class ChessPiece {

    private BufferedImage image;
    private String location;
    private String type;
    private final String color;

    public ChessPiece(BufferedImage image, String type, String location, String color) {
        this.image = image;
        this.type = type;
        this.location = location;
        this.color = color;
    }

    public ChessPiece(ChessPiece p) {
        this.image = p.getImage();
        this.type = p.getType();
        this.location = p.getLocation();
        this.color = p.getColor();
    }

    public String getLocation() {
        return location;
    }

    public String getColor() {
        return color;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BufferedImage getImage() {
        return image;
    }

    String getType() {
        return type;
    }
}

abstract class ChessPieceMouseAdapter extends MouseAdapter {

    private Chessboard chessboard;
    private ChessPiece draggedChessPiece;
    private boolean dragging;
    private Rectangle pieceRectangle;
    private Point draggedPieceInitialLocation;
    private Point pressedPoint;

    public ChessPieceMouseAdapter() {
        dragging = false;
        draggedPieceInitialLocation = new Point();
        pressedPoint = new Point();
    }

    public Point getDraggedPieceLocation() {
        return new Point(pieceRectangle.x, pieceRectangle.y);
    }

    public ChessPiece getDraggedPiece() {
        return draggedChessPiece;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        pressedPoint = me.getPoint();
        ArrayList<ChessboardBlock> chessBoardBlocks = chessboard.getChessBoardBlocks();
        for (int i = 0; i < chessBoardBlocks.size(); i++) {
            if (chessBoardBlocks.get(i).getChessPiece() != null) {
                pieceRectangle = chessBoardBlocks.get(i).getBounds();
                if (pieceRectangle.contains(pressedPoint)) {
                    ChessPiece chessPiece = chessBoardBlocks.get(i).getChessPiece();
                    if (chessPieceSelected(chessPiece, chessBoardBlocks.get(i))) {
                        draggedChessPiece = new ChessPiece(chessPiece);
                        chessBoardBlocks.get(i).setPiece(null);

                        draggedPieceInitialLocation.x = pieceRectangle.x;
                        draggedPieceInitialLocation.y = pieceRectangle.y;

                        dragging = true;
                        chessboard.repaint();
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        ArrayList<ChessboardBlock> chessBoardBlocks = chessboard.getChessBoardBlocks();
        for (int i = 0; i < chessBoardBlocks.size(); i++) {
            pieceRectangle = chessBoardBlocks.get(i).getBounds();
            if (pieceRectangle.contains(me.getPoint())) {
                if (draggedChessPiece != null) {
                    chessPiecePlaced(draggedChessPiece, chessBoardBlocks.get(i));
                }
            }
        }
        dragging = false;
        draggedChessPiece = null;
        chessboard.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        dragging = true;
        pieceRectangle.x = me.getX() - (pressedPoint.x - draggedPieceInitialLocation.x);
        pieceRectangle.y = me.getY() - (pressedPoint.y - draggedPieceInitialLocation.y);
        chessboard.repaint();
    }

    boolean isDragging() {
        return dragging;
    }

    abstract boolean chessPieceSelected(ChessPiece chessPiece, ChessboardBlock cb);

    abstract void chessPiecePlaced(ChessPiece chessPiece, ChessboardBlock cb);

    void setChessboard(Chessboard chessBoard) {
        this.chessboard = chessBoard;
    }
}
