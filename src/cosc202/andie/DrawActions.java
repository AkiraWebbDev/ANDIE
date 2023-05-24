package cosc202.andie ; 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.* ;

/**
 * <p>
 * Class for Draw Actions
 * </p>
 * 
 * <p>
 * This class adds to the Mouse menu and calls to their respective classes
 * This includes a draw function
 * </p>
 *  
 * @author Samuel Goddard
 * @version 1.0
 */
public class DrawActions implements KeyListener {
    
    /** A list of actions for the Mouse menu. */
    protected ArrayList<Action> actions ; 
    /**
     * <p>
     * Create a set of Draw menu actions.
     * </p>
     */
    public DrawActions() {
       
        actions = new ArrayList<Action>();
        actions.add( new DrawLineAction( Andie.getLanguage("draw_line") , null , Andie.getLanguage("draw_line_description") , Integer.valueOf( KeyEvent.VK_D ) ) ) ;
        actions.add( new DrawCircleAction( Andie.getLanguage("draw_oval") , null , Andie.getLanguage("draw_oval_description") , Integer.valueOf( KeyEvent.VK_D ) ) ) ;
        actions.add( new DrawRectangleAction( Andie.getLanguage("draw_rectangle") , null , Andie.getLanguage("draw_rectangle_description") , Integer.valueOf( KeyEvent.VK_D ) ) ) ;
        actions.add( new ColorAction( Andie.getLanguage("color") , null , Andie.getLanguage("color_description") , Integer.valueOf( KeyEvent.VK_D ) ) ) ;
        actions.add( new BrushAction( Andie.getLanguage("brush") , null , Andie.getLanguage("brush_description") , Integer.valueOf( KeyEvent.VK_D ) ) ) ;

    }

    /**
     * <p>
     * Creates a menu containing a list of all draw actions
     * </p>
     * @return the draw menu
     */
    public JMenu createMenu() {
        
        JMenu drawMenu = new JMenu( Andie.getLanguage("draw_menu") ) ;

        for ( Action action : actions ) {

            drawMenu.add( new JMenuItem( action ) ) ;

        }

        return drawMenu;

    }

    /**
     * <p>
     * Action to start drawing a line
     * </p>
     * 
     * @see DrawLine
     */
    public class DrawLineAction extends ImageAction {
        /**
         * <p>
         * Starts drawing action
         * </p>
         * 
         * @param name The name of the action (ignored if null).
         * @param icon An icon to use to represent the action (ignored if null).
         * @param desc A brief description of the action  (ignored if null).
         * @param mnemonic A mnemonic key to use as a shortcut  (ignored if null).
         */
        DrawLineAction( String name , ImageIcon icon , String desc , Integer mnemonic ) {

            super( name , icon , desc , mnemonic ) ;


        }
        /**
         * <p>
         * Callback for when draw is selected
         * </p>
         * 
         * @param e The event triggering this callback. 
         */
        public void actionPerformed( ActionEvent e ) {

            target.drawLineActive( true ) ; 
            
        }

    }

    /**
     * <p>
     * Action to start drawing a circle
     * </p>
     * 
     * @see DrawLine
     */
    public class DrawCircleAction extends ImageAction {
        /**
         * <p>
         * Starts drawing action
         * </p>
         * 
         * @param name The name of the action (ignored if null).
         * @param icon An icon to use to represent the action (ignored if null).
         * @param desc A brief description of the action  (ignored if null).
         * @param mnemonic A mnemonic key to use as a shortcut  (ignored if null).
         */
        DrawCircleAction( String name , ImageIcon icon , String desc , Integer mnemonic ) {

            super( name , icon , desc , mnemonic ) ;


        }
        /**
         * <p>
         * Callback for when draw is selected
         * </p>
         * 
         * @param e The event triggering this callback. 
         */
        public void actionPerformed( ActionEvent e ) {

            target.drawCircleActive( true ) ; 
            
        }

    }

    /**
     * <p>
     * Action to start drawing a rectangle
     * </p>
     * 
     * @see DrawLine
     */
    public class DrawRectangleAction extends ImageAction {
        /**
         * <p>
         * Starts drawing action
         * </p>
         * 
         * @param name The name of the action (ignored if null).
         * @param icon An icon to use to represent the action (ignored if null).
         * @param desc A brief description of the action  (ignored if null).
         * @param mnemonic A mnemonic key to use as a shortcut  (ignored if null).
         */
        DrawRectangleAction( String name , ImageIcon icon , String desc , Integer mnemonic ) {

            super( name , icon , desc , mnemonic ) ;


        }
        /**
         * <p>
         * Callback for when draw is selected
         * </p>
         * 
         * @param e The event triggering this callback. 
         */
        public void actionPerformed( ActionEvent e ) {

            target.drawRectangleActive( true ) ; 
            
        }

    }

    public class ColorAction extends ImageAction {
        /**
         * <p>
         * Chooses color for lines
         * </p>
         * 
         * @param name The name of the action (ignored if null).
         * @param icon An icon to use to represent the action (ignored if null).
         * @param desc A brief description of the action  (ignored if null).
         * @param mnemonic A mnemonic key to use as a shortcut  (ignored if null).
         */
        ColorAction( String name , ImageIcon icon , String desc , Integer mnemonic ) {

            super( name , icon , desc , mnemonic ) ;


        }
        /**
         * <p>
         * Callback for when draw is selected
         * </p>
         * 
         * @param e The event triggering this callback. 
         */
        public void actionPerformed( ActionEvent e ) {

            Color color = JColorChooser.showDialog( Andie.getFrame() , Andie.getLanguage("color_select") , Color.WHITE ) ; 
            target.setColor( color ) ; 
            
        }

    }

    public class BrushAction extends ImageAction {
        /**
         * <p>
         * Chooses color for lines
         * </p>
         * 
         * @param name The name of the action (ignored if null).
         * @param icon An icon to use to represent the action (ignored if null).
         * @param desc A brief description of the action  (ignored if null).
         * @param mnemonic A mnemonic key to use as a shortcut  (ignored if null).
         */
        BrushAction( String name , ImageIcon icon , String desc , Integer mnemonic ) {

            super( name , icon , desc , mnemonic ) ;


        }
        /**
         * <p>
         * Callback for when draw is selected
         * </p>
         * 
         * @param e The event triggering this callback. 
         */
        public void actionPerformed( ActionEvent e ) {

            SpinnerNumberModel radiusModel = new SpinnerNumberModel(1, 1, 10, 1);
            JSpinner radiusSpinner = new JSpinner(radiusModel);
            int option = JOptionPane.showOptionDialog(null, radiusSpinner, Andie.getLanguage("brush") , JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            int sliderSize = 1 ;
            // Check the return value from the dialog box.
            if (option == JOptionPane.CANCEL_OPTION) {
                return;
            } else if (option == JOptionPane.OK_OPTION) {
                sliderSize = radiusModel.getNumber().intValue();
            }

            target.setSlider( sliderSize ) ; 
            
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}