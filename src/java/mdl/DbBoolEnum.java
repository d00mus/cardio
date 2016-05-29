/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

/**
 *
 * @author d00mus
 */
public enum DbBoolEnum {

 T{
 public boolean getAsBool(){
     return true;
 }
}
,F{
 public boolean getAsBool(){
     return false;
 }
};

  public abstract boolean getAsBool();
  static public DbBoolEnum valueOf(boolean b){
     if(b)return T;
  return F;  
 }
}
