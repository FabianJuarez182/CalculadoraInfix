/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class DoubleLinkedList<T> extends List<T> {
    /**
    * Copyright (C), 2022-2023, The_Kiesling FabianJuarez SaraEcheverria 
    * @author Jose Pablo Kiesling, Fabian Juarez y Sara Echeverria
    Nombre del programa: DoubleLinkedList.java
    @version: 
        - Creación: 02/03/2022
        - Última modificación: 

    Clase abstracta de listas
     */
    
    //---------------------------PROPIEDADES--------------------------
    protected DoubleNode<T> start;
    protected DoubleNode<T> end;
    int count;

    //---------------------------MÉTODOS------------------------------
    /*****************************************************************
     * inserta un elemento al final
     * @param value
     */    
    public void InsertAtEnd(T value) {
        DoubleNode<T> newNode = new DoubleNode<T>(value);
		
		if (IsEmpty()) { //Si está vacío
			start = newNode;
			end = newNode;
			start.setNext(start);
			start.setPrevious(start);
		} else {
			newNode.setNext(start);
			start.setPrevious(newNode);
			newNode.setPrevious(end);
			end.setNext(newNode);
			start = newNode;
		}
		
		count++;
    }
    //****************************************************************

    /*****************************************************************
     * elimina el elemento al final
     * @return
     */
    public T DeleteAtEnd() {
        DoubleNode<T> actualNode = start;
        DoubleNode<T> previousNode = null;

        while(actualNode.getNext()!= null){
            previousNode = actualNode;
            actualNode = (DoubleNode<T>) actualNode.getNext();
        }
        if(previousNode == null)
            start = null;
        
        else
            previousNode.setNext(null);
        count--;
        return (T) previousNode.getValue();

    }
    //****************************************************************
    
}