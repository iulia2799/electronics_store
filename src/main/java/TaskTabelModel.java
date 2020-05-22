import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class TaskTabelModel extends DefaultTableModel {

    public TaskTabelModel() {
        super(new String[]{"nr mat","TASK DESCRIPTION","REALIZED"}, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clazz = String.class;
        switch (columnIndex) {
            case 0:
                clazz = Integer.class;
                break;
            case 2:
                clazz = Boolean.class;
                break;
        }
        return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (aValue instanceof Boolean && column == 2) {
           // System.out.println(aValue);
            if(aValue.equals(true))
            {
                System.out.println(aValue);
            }
            Vector rowData = (Vector)getDataVector().get(row);
            rowData.set(2, (boolean)aValue);
            fireTableCellUpdated(row, column);
        }
    }

}


