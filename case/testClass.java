public class testClass {
    void test(){
        return ConfirmationDialog.create(this, id,
                        R.string.dialog_confirm_delete_title, "",
                        R.string.dialog_confirm_delete_confirm_button,
                        R.string.dialog_confirm_delete_cancel_button,
                        new Runnable() {
                            @Override
                            public void run() {
                                triggerDelete();
                                finish();
                            }
                        },
                        new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        });
       }
}
