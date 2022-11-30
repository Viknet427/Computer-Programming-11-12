import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import flanagan.io.*;
import java.awt.Image;


public class Gridder extends javax.swing.JFrame 
                                        implements MouseListener, MouseMotionListener,
                                                            ActionListener {
     
    protected final int gridCount=100;  //how many squares wide our drawing area is
    protected int[][]   grid = new int[gridCount][gridCount]; //create the matrix
    private final int squareSize=5; //the size length of individual squares in pixels
    private final int gridSize=gridCount*squareSize;  //size of entire draw grid in pixels
    private final int offSet=50;  //how far from top/left edge do we draw the grid
    private int penColor = 1; //keeps track of current drawing color
    private Color[] colors; //our array of colors
    private Image ib;  //we do all drawing onto this image, it acts as an image buffer
    private Graphics ibg;  //will be set to our image buffer's graphic object
    private String filename;
    
    private Timer timmy;
    private boolean active=false;
    private int stepDelay = 500;
    private Color borderColor=new Color(20,20,20);
    
    
    //constructor for our GridderFrame
    public Gridder() {
        initComponents();
        addMouseListener(this);  //registers this frame to receive mouse clicks
        addMouseMotionListener(this); //register this frame to receive mouse motions
        setUpImageBuffer();
        takeCareOfResizing();
        setUpColors();
        clearGrid();
        draw();
    }

    
    //set our image (buffer) to a new image of the correct size
    public void setUpImageBuffer(){
        ib=this.createImage(gridSize+1,gridSize+1);
        ibg=ib.getGraphics();
    }

    
    //experimental code that redraws the grid after user resizes the window
    //works some of the time... still in progress
    public void takeCareOfResizing(){
         this.addComponentListener(new ComponentAdapter() {
           public void componentResized(ComponentEvent e) {
              draw(); 
           }  
           public void componentMoved(ComponentEvent e) {
              draw();
           }
         });
    }
    
    public void setUpColors(){
        colors=new Color[2];
        colors[0]=Color.darkGray;  colors[1]=Color.white; 
        
    }
    
    
    //fills the grid with 1's (represents white!)
    public void clearGrid(){
        for(int c=0; c<gridCount; c++)
            for(int r=0; r<gridCount; r++)
                grid[c][r]=0;
        
        draw();
    } 
    
     
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) {  }
    
    
    //will use the mouse x and y coordinates and figure out which square in the
    //draw area was clicked and pass this information to the clickGrid method
    public void mouseClicked(MouseEvent e) { 
        int x = e.getX(); int y = e.getY(); 
        int row = (y-offSet)/squareSize;
        int col = (x-offSet)/squareSize;
        System.out.println("Click: " + col + ", " + row);
        //if inside our grid, call clickGrid passing it the col and row
        if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
           clickGrid(col, row);
    }
  
    
    //will use the mouse x and y coordinates and figure out which square in the
    //draw area dragging is occurring and pass this information to the clickGrid method    
    public void mouseDragged(MouseEvent e) { 
      int x = e.getX(); int y = e.getY(); 
      int row = (y-offSet )/squareSize;
      int col = (x-offSet )/squareSize;
      System.out.println("Drag:  " + col + ", " + row);
      //if inside our grid, call dragGrid passint it the col and row
      if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
         dragGrid(col, row);       
    }
    
    public void mouseMoved(MouseEvent e) { 
        //System.out.println("Moving at " + e.getX() + "," +  e.getY() );  
    }
    
    //set a square in the grid to the color value as long as the values are valid
    public void colorSquare(int col, int row, int colorValue){
        grid[col][row] = colorValue;
        draw();
    }
    
    
    //any mouse click is forwarded to this method with the col and row of the
    //square clicked provided as parameters.  Comes from public void mouseClicked.
    public void clickGrid( int col, int row ){
        colorSquare(col, row, penColor); 
    }
    
    
    //any mouse drag is forwarded to this method with the col and row of the
    //square dragged over provided as parameters.  Comes from public void mouseDragged.
    public void dragGrid( int col, int row) {
        colorSquare(col, row, penColor);   
    }
    
    
    //draws the image based on the values stored in the grid.
    //we will draw on the image buffer's graphics object and then when we are
    //all done we will copy the image buffer onto the Frame's graphic object.
    public void draw(){
        
        //clear the area, draw white background
        ibg.clearRect(0, 0, gridSize,gridSize);
        ibg.setColor(Color.white);
        ibg.fillRect(0, 0, gridSize, gridSize);
        
        //draws individual squares (pass this method the frames graphics object
        drawSquares(ibg);
        
        //draws a black border around edge of grid
        ibg.setColor(Color.black);
        ibg.drawRect(0,0,gridSize,gridSize);
        
        //all done drawing your stuff onto the image buffer?
        //get the frame's graphics object and draw our image buffer onto the frame
        Graphics g = this.getGraphics();
        g.drawImage(ib,offSet,offSet,this);
    }
    
    
    //draws the individual colored squares that make the grid using the values
    //stored in the grid matrix.
    public void drawSquares(Graphics g){
       //draw each square (remember that squareSize is size of each square...
       g.setColor(Color.black);
       for(int r=0; r<gridCount; r++){
           for(int c=0; c<gridCount; c++) {
               g.setColor(colors[ grid[c][r] ] );
               g.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);      
               g.setColor(borderColor);
               g.drawRect(c*squareSize, r*squareSize, squareSize, squareSize);
           }
       }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textInfo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        buttonOpen = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonBlack = new javax.swing.JButton();
        buttonWhite = new javax.swing.JButton();
        jButtonStep = new javax.swing.JButton();
        jButtonCopy = new javax.swing.JButton();
        jButtonPaste = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jSliderDelay = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        ProblemOne = new javax.swing.JButton();
        ProblemTwo = new javax.swing.JButton();
        ProblemThree = new javax.swing.JButton();
        ProblemFour = new javax.swing.JButton();
        ProblemFive = new javax.swing.JButton();
        ProblemSix = new javax.swing.JButton();
        ProblemSeven = new javax.swing.JButton();
        ProblemEight = new javax.swing.JButton();
        ProblemNine = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setMinimumSize(new java.awt.Dimension(950, 660));

        textInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textInfo.setText("give user info here...");

        buttonOpen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonOpen.setText("Open");
        buttonOpen.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSave.setText("Save");
        buttonSave.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonBlack.setText("BLACK");
        buttonBlack.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonBlack.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonBlack.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlackActionPerformed(evt);
            }
        });

        buttonWhite.setText("WHITE");
        buttonWhite.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonWhite.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonWhite.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWhiteActionPerformed(evt);
            }
        });

        jButtonStep.setText("STEP");
        jButtonStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepActionPerformed(evt);
            }
        });

        jButtonCopy.setText("Copy");

        jButtonPaste.setText("Paste");

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        jSliderDelay.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSliderDelay.setMajorTickSpacing(500);
        jSliderDelay.setMaximum(2000);
        jSliderDelay.setMinorTickSpacing(500);
        jSliderDelay.setPaintLabels(true);
        jSliderDelay.setPaintTicks(true);
        jSliderDelay.setSnapToTicks(true);
        jSliderDelay.setValue(500);
        jSliderDelay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderDelayStateChanged(evt);
            }
        });

        ProblemOne.setText("Problem 1");
        ProblemOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemOneActionPerformed(evt);
            }
        });

        ProblemTwo.setText("Problem 2");
        ProblemTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemTwoActionPerformed(evt);
            }
        });

        ProblemThree.setText("Problem 3");
        ProblemThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemThreeActionPerformed(evt);
            }
        });

        ProblemFour.setText("Problem 4");
        ProblemFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemFourActionPerformed(evt);
            }
        });

        ProblemFive.setText("Problem 5");
        ProblemFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemFiveActionPerformed(evt);
            }
        });

        ProblemSix.setText("Problem 6");
        ProblemSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemSixActionPerformed(evt);
            }
        });

        ProblemSeven.setText("Problem 7");
        ProblemSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemSevenActionPerformed(evt);
            }
        });

        ProblemEight.setText("Problem 8");
        ProblemEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemEightActionPerformed(evt);
            }
        });

        ProblemNine.setText("Problem 9");
        ProblemNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemNineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProblemOne, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(ProblemTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemFive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemSix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemSeven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemEight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemNine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ProblemEight, ProblemFive, ProblemFour, ProblemNine, ProblemOne, ProblemSeven, ProblemSix, ProblemThree, ProblemTwo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ProblemOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemTwo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemThree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemFour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemFive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemSix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemSeven)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemEight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProblemNine)
                .addGap(0, 102, Short.MAX_VALUE))
        );

        jLabel1.setText("set delay");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonBlack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonPaste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonBlack, buttonClear, buttonOpen, buttonRefresh, buttonSave, buttonWhite, jButtonCopy, jButtonPaste, jButtonRun, jButtonStep});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(buttonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPaste)
                        .addGap(20, 20, 20)
                        .addComponent(buttonBlack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWhite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRun)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonBlack, buttonWhite});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonClear, buttonRefresh});

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
       
    //saves the current picture data in CS format
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
      //String curDir = System.getProperty("user.dir");
      //System.out.println("Your directory is " + curDir);
      FileChooser FC = new FileChooser();
      FC.selectFile();
      filename=FC.getDirPath() +"/"+ FC.getFileName();
      System.out.println("Filename: " + filename);
      FC.close();
      
      FileOutput FO = new FileOutput(filename,"w");
    
      for(int r=0; r<gridCount; r++) {
         for(int c=0; c<gridCount; c++) {
             int num = grid[c][r];
             if (num<10)
                 FO.print("0"+num);
             else
                 FO.print(num);
         }
         FO.println(""); //go to new line
      }
      FO.close();
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    //opens a CS format file and loads the image data into the grid
    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
      FileChooser FC = new FileChooser();
      FC.selectFile();
      filename=FC.getDirPath() +"/"+ FC.getFileName();
      System.out.println(filename);
      FC.close();
      
      FileInput FI = new FileInput(filename);
      int num=FI.numberOfLines();
      if (num!=gridCount){
          System.out.println("Not enough lines in file!");
          return;
      }
      
      //read each row.  go through row two characters at a time and convert to number
      for(int r=0; r<gridCount; r++) {
          String line = FI.readLine();                         //read the next line
          for(int c=0; c<gridCount; c++){                 //or (int c=0; c<gridCount*2; c=c+2)
              String temp=line.substring(c*2, c*2+2);   //0,2,4,6,8,...
              int value=Integer.parseInt(temp);           //convert to int
              grid[c][r]=value;                                  //put in grid
          }
      }
      FI.close();
      
      //lets see what you just read!
      draw();
      
    }//GEN-LAST:event_buttonOpenActionPerformed

    //redraws the canvas when the picture disappears
    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        draw();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clearGrid();
    }//GEN-LAST:event_buttonClearActionPerformed


    private void buttonBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlackActionPerformed
        penColor=0;
    }//GEN-LAST:event_buttonBlackActionPerformed

    private void buttonWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWhiteActionPerformed
        penColor=1;
    }//GEN-LAST:event_buttonWhiteActionPerformed

    public boolean isAlive(int c, int r) {
        //if cell is in grid and alive, return true
        //outside grid or not alive, return false
        return(true);
    }
    
    private void jButtonStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepActionPerformed
        step();
    }//GEN-LAST:event_jButtonStepActionPerformed

    public int countNeighbors(int c, int r){
       return(0);
    }
    
    public void step() {
        //empty now
        //sample code, take this out!   randomly pick a spot to turn white
        int col = (int)(Math.random()*gridCount);
        int row = (int)(Math.random()*gridCount);
        grid[col][row] = 1;
        
        
        //leave this in here or you won't see anything happen!
        draw();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //this event is called by the timer...
        //System.out.println("Calling Step...");
        //System.out.println(e.getSource());
        step();
    }
    
    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        //create timer if it doesn't exist.  If it does exist, turn it on!
        System.out.println("Run/Pause Button Pressed");
        if (active==false) {
            if (timmy==null) {
              timmy=new Timer(stepDelay,this);
              timmy.setInitialDelay(100); 
              timmy.setDelay(stepDelay);
            }
            
            timmy.start();
            active=true;
            jButtonRun.setText("Pause...");
        }
        else { //turn timer off
            active=false;
            timmy.stop();
            jButtonRun.setText("Run...");
        }
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jSliderDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderDelayStateChanged
        // TODO add your handling code here:
        stepDelay=jSliderDelay.getValue();
        if (stepDelay==0) {
            stepDelay=1;
        }
        if (timmy!=null)
            timmy.setDelay(stepDelay);
    }//GEN-LAST:event_jSliderDelayStateChanged

    private void ProblemOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemOneActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < 100; i++) {

            int ran = (int) (Math.random() * 100);
            int ran2 = (int) (Math.random() * 100);
            grid[ran][ran2] = 1;

        }
        draw();

    }//GEN-LAST:event_ProblemOneActionPerformed

    private void ProblemTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemTwoActionPerformed
        // TODO add your handling code here:

        int ran = (int)(Math.random()*100);
        for (int i = 0; i < grid[ran].length; i++) {

            grid[ran][i] = 1;

        }
        draw();

    }//GEN-LAST:event_ProblemTwoActionPerformed

    private void ProblemThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemThreeActionPerformed
        // TODO add your handling code here:

        clearGrid();
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length/2; j++) {

                grid[i][j] = 1;

            }

        }
        draw();

    }//GEN-LAST:event_ProblemThreeActionPerformed

    private void ProblemFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemFourActionPerformed
        // TODO add your handling code here:

        int counter = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {

                    counter += 1;

                }

            }
            textInfo.setText(Integer.toString(counter));
            draw();

        }

    }//GEN-LAST:event_ProblemFourActionPerformed

    private void ProblemFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemFiveActionPerformed
        // TODO add your handling code here:

        clearGrid();
        for (int i = 0; i < grid.length; i++) {

            grid[i][i] = 1;
            grid[i][grid.length-1-i] = 1;

        }
        draw();

    }//GEN-LAST:event_ProblemFiveActionPerformed

    private void ProblemSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemSixActionPerformed
        // TODO add your handling code here:

        int[][] temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {

                    temp[i][j] = 0;

                }

                else if (grid[i][j] == 0) {

                    temp[i][j] = 1;

                }

            }

        }
        grid = temp;
        draw();

    }//GEN-LAST:event_ProblemSixActionPerformed

    private void ProblemSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemSevenActionPerformed
        // TODO add your handling code here:

        int[][] temp = new int[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 0) {

                    if (i != 0) {

                         if (grid[i-1][j] == 1) {

                             counter += 1;

                         }

                         if (j != 0 && grid[i-1][j-1] == 1) {

                             counter += 1;

                         }

                         if (j != grid[i].length-1 && grid[i-1][j+1] == 1) {

                             counter += 1;

                         }

                    }

                    if (j != 0) {

                        if (grid[i][j-1] == 1) {

                            counter += 1;

                        }

                        if (i != grid.length-1 && grid[i+1][j-1] == 1) {

                            counter += 1;

                        }

                    }

                    if (i != grid.length-1) {

                        if (grid[i+1][j] == 1) {

                            counter += 1;

                        }

                        if (j != grid[i].length-1 && grid[i+1][j+1] == 1) {

                            counter += 1;

                        }

                    }

                    if (j != grid[i].length-1 && grid[i][j+1] == 1) {

                        counter += 1;

                    }

                    if (counter >= 2) {

                        temp[i][j] = 1;

                    }
                    counter = 0;

                }

            }

        }

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (temp[i][j] == 1 && grid[i][j] != 1) {

                    grid[i][j] = 1;

                }

            }

        }
        draw();

    }//GEN-LAST:event_ProblemSevenActionPerformed

    private void ProblemEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemEightActionPerformed
        // TODO add your handling code here:

        int[][] temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < temp.length; i++) {

            if (i == 99) {

                temp[i] = grid[grid.length-1-i];

            }

            else {

                temp[i] = grid[i+1];

            }

        }
        grid = temp;
        draw();

    }//GEN-LAST:event_ProblemEightActionPerformed

    private void ProblemNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemNineActionPerformed
        // TODO add your handling code here:

        int[][] temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                temp[i][j] = grid[j][grid.length-1-i];

            }

        }
        grid = temp;
        draw();

    }//GEN-LAST:event_ProblemNineActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gridder().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProblemEight;
    private javax.swing.JButton ProblemFive;
    private javax.swing.JButton ProblemFour;
    private javax.swing.JButton ProblemNine;
    private javax.swing.JButton ProblemOne;
    private javax.swing.JButton ProblemSeven;
    private javax.swing.JButton ProblemSix;
    private javax.swing.JButton ProblemThree;
    private javax.swing.JButton ProblemTwo;
    private javax.swing.JButton buttonBlack;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonWhite;
    private javax.swing.JButton jButtonCopy;
    private javax.swing.JButton jButtonPaste;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonStep;
    private javax.swing.JLabel jLabel1;    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderDelay;
    private javax.swing.JTextField textInfo;
    // End of variables declaration//GEN-END:variables

} //end of class