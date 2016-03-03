package eg.edu.guc.yugioh.gui;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TraverseToLocation implements Runnable {
	private Point to;
	private Point from;
	private GUI gui;
	private JLabel i;
	private double ratioX;
	private double ratioY;
	public TraverseToLocation(GUI gui,ImageIcon i,Point from,Point to){
		this.to = to;
		this.from = from;
		this.gui = gui;
		this.i=new JLabel(i);
		
		ratioX = Math.abs((to.getX()-from.getX())/100);
		ratioY = Math.abs((to.getY()-from.getY())/100);
	}
	
	public void run() {
		if((from.getX()==to.getX()&&from.getY()==to.getY())||(from.getX()<0)||(from.getY()<0)){
		i.setLocation((int)to.getX(),(int)to.getY());
		i.setSize(66, 190);
		gui.getbackground().add(i);
		return;
		}else{
			try {
				for(int j=0;j<100;j++){
				Thread.sleep(1);
				if((from.getX()==to.getX()-1&&from.getY()==to.getY()-1)||(from.getX()==to.getX()&&from.getY()==to.getY())||(from.getX()==to.getX()-2&&from.getY()==to.getY()-2)){
				from.x=(int) (from.getX()+ratioX);
				from.y=(int) (from.getY()+ratioY);
				//System.out.println(from.x+" "+from.y);
				break;
				}else{
					//System.out.println(from.x+" "+from.y);
					if(from.getX()>to.getX()&&from.getY()<to.getY()){
						//from.setLocation(from.getX()-ratioX,from.getY()+ratioY);
						from.x=(int) (from.getX()-ratioX);
						from.y=(int) (from.getY()+ratioY);
					}else{
						if(from.getX()<to.getX()&&from.getY()>to.getY()){
						//	from.setLocation(from.getX()+ratioX,from.getY()-ratioY);
							from.x=(int) (from.getX()+ratioX);
							from.y=(int) (from.getY()-ratioY);
						}else{
							if(from.getX()>to.getX()&&from.getY()>to.getY()){
						//	from.setLocation(from.getX()+ratioX,from.getY()+ratioY);
							from.x=(int) (from.getX()+ratioX);
							from.y=(int) (from.getY()+ratioY);
							}else{
								if(from.getX()<to.getX()&&from.getY()<to.getY()){
									from.x=(int) (from.getX()-ratioX);
									from.y=(int) (from.getY()-ratioY);
								}else{
									if(from.getX()==to.getX()&&from.getY()<to.getY()){
										from.y=(int) (from.getY()+ratioY);
									}else{
										if(from.getX()==to.getX()&&from.getY()>to.getY()){
											from.y=(int) (from.getY()-ratioY);
										}else{
											if(from.getX()>to.getX()&&from.getY()==to.getY()){
												from.x=(int) (from.getX()-ratioX);
											}else{
												if(from.getX()<to.getX()&&from.getY()==to.getY())
												from.x=(int) (from.getX()+ratioX);
											}
										}
									}
								}
							}
						}
					}
				}
				i.setLocation(from);
				i.setSize(66, 190);
				gui.getbackground().add(i);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
