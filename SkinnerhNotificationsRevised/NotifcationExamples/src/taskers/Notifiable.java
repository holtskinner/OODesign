/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskers;

/**
 *
 * @author dalemusser
 */
@FunctionalInterface
public interface Notifiable {
    public void notify(String notification);
}
