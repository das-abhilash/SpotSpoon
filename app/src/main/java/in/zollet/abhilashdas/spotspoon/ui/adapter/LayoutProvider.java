package in.zollet.abhilashdas.spotspoon.ui.adapter;

public interface LayoutProvider {


     int getLayoutId(int pos);
     <T>T getModel(int pos);
     Object getHandler();

     int getSize();
     String getTitle(int pos);
}