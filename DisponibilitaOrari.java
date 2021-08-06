import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Pagina Disponibilità Orari, in cui sono presenti (in ordine a partire dall'alto):
    - 4 JButton per spostarsi da un menu all'altro
    - 1 JLabel in cui viene spiegato il funzionamento dei pulsanti sottostanti
    - 5 colonne * 4 righe di JButton con i pulsanti dell'orario di consegna scelto dal cliente,
      alla pressione di un pulsante vengono mostrati gli ordini già presi in tale orario
      (il colore del pulsante cambia se sono già presenti ordini)
      Una colonna di orari (ES: quella delle 18) viene rimossa una volta superata l'ora
      (ES: se sono le 19 la colonna delle 18 viene tolta)
 */

public class DisponibilitaOrari extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JButton SeiButton;
    private final JButton SeiQuartoButton;
    private final JButton SeiMezzaButton;
    private final JButton SeiTreButton;

    private final JButton SetteButton;
    private final JButton SetteQuartoButton;
    private final JButton SetteMezzaButton;
    private final JButton SetteTreButton;

    private final JButton OttoButton;
    private final JButton OttoQuartoButton;
    private final JButton OttoMezzaButton;
    private final JButton OttoTreButton;

    private final JButton NoveButton;
    private final JButton NoveQuartoButton;
    private final JButton NoveMezzaButton;
    private final JButton NoveTreButton;

    private final JButton DieciButton;
    private final JButton DieciQuartoButton;
    private final JButton DieciMezzaButton;
    private final JButton DieciTreButton;

    private final JButton Menu1Button;
    private final JButton Menu2Button;
    private final JButton Menu3Button;
    private final JButton Menu4Button;


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
    LocalDateTime now = LocalDateTime.now();
    int time = Integer.parseInt(dtf.format(now));

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DisponibilitaOrari::new);
    }

    public DisponibilitaOrari() {
        super("Disponibilità Orari");
        SeiButton = new JButton("18:00");
        SeiButton.addActionListener(this);
        SeiQuartoButton = new JButton("18:15");
        SeiQuartoButton.addActionListener(this);
        SeiMezzaButton = new JButton("18:30");
        SeiMezzaButton.addActionListener(this);
        SeiTreButton = new JButton("18:45");
        SeiTreButton.addActionListener(this);

        SetteButton = new JButton("19:00");
        SetteButton.addActionListener(this);
        SetteQuartoButton = new JButton("19:15");
        SetteQuartoButton.addActionListener(this);
        SetteMezzaButton = new JButton("19:30");
        SetteMezzaButton.addActionListener(this);
        SetteTreButton = new JButton("19:45");
        SetteTreButton.addActionListener(this);

        OttoButton = new JButton("20:00");
        OttoButton.addActionListener(this);
        OttoQuartoButton = new JButton("20:15");
        OttoQuartoButton.addActionListener(this);
        OttoMezzaButton = new JButton("20:30");
        OttoMezzaButton.addActionListener(this);
        OttoTreButton = new JButton("20:45");
        OttoTreButton.addActionListener(this);

        NoveButton = new JButton("21:00");
        NoveButton.addActionListener(this);
        NoveQuartoButton = new JButton("21:15");
        NoveQuartoButton.addActionListener(this);
        NoveMezzaButton = new JButton("21:30");
        NoveMezzaButton.addActionListener(this);
        NoveTreButton = new JButton("21:45");
        NoveTreButton.addActionListener(this);

        DieciButton = new JButton("22:00");
        DieciButton.addActionListener(this);
        DieciQuartoButton = new JButton("22:15");
        DieciQuartoButton.addActionListener(this);
        DieciMezzaButton = new JButton("22:30");
        DieciMezzaButton.addActionListener(this);
        DieciTreButton = new JButton("22:45");
        DieciTreButton.addActionListener(this);

        Menu1Button = new JButton("sez1");
        Menu2Button = new JButton("sez2");
        Menu3Button = new JButton("sez3");
        Menu4Button = new JButton("sez4");


        JPanel porari = new JPanel(new GridLayout(1, 5));
      //  if (time <= 18) {
            JPanel p = new JPanel(new GridLayout(4, 1));
            p.add(SeiButton);
            p.add(SeiQuartoButton);
            p.add(SeiMezzaButton);
            p.add(SeiTreButton);
            porari.add(p);
     //   }
        if (time <= 19) {
            JPanel p1 = new JPanel(new GridLayout(4, 1));
            p1.add(SetteButton);
            p1.add(SetteQuartoButton);
            p1.add(SetteMezzaButton);
            p1.add(SetteTreButton);
            porari.add(p1);
        }
        if (time <= 20) {
            JPanel p2 = new JPanel(new GridLayout(4, 1));
            p2.add(OttoButton);
            p2.add(OttoQuartoButton);
            p2.add(OttoMezzaButton);
            p2.add(OttoTreButton);
            porari.add(p2);
        }
        if (time <= 21) {
            JPanel p3 = new JPanel(new GridLayout(4, 1));
            p3.add(NoveButton);
            p3.add(NoveQuartoButton);
            p3.add(NoveMezzaButton);
            p3.add(NoveTreButton);
            porari.add(p3);
        }
        if (time <= 22) {
            JPanel p4 = new JPanel(new GridLayout(4, 1));
            p4.add(DieciButton);
            p4.add(DieciQuartoButton);
            p4.add(DieciMezzaButton);
            p4.add(DieciTreButton);
            porari.add(p4);
        }

        JPanel pmenu = new JPanel(new GridLayout(1, 4));
        pmenu.add(Menu1Button);
        pmenu.add(Menu2Button);
        pmenu.add(Menu3Button);
        pmenu.add(Menu4Button);

        //JPanel pbanner = new JPanel(new GridLayout(1,1));
        // pbanner.add(new JLabel("Scegliere l'orario di consegna:"), SwingConstants.CENTER);

        JPanel pintermediate = new JPanel(new BorderLayout());
        pintermediate.add(pmenu, BorderLayout.NORTH);
        pintermediate.add(new JLabel("Scegliere l'orario di consegna:"), BorderLayout.CENTER);

        JPanel pfinal = new JPanel(new BorderLayout());
        pfinal.add(pintermediate, BorderLayout.NORTH);
        pfinal.add(porari, BorderLayout.SOUTH);


        /* JFrame methods called */
        setContentPane(pfinal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SeiButton) {
            try {
                AzioneOrariButton click = new AzioneOrariButton("18:00");
                //Dopo essere passata dal DBManager (in cui va nella catch segnata)
                //Finisce nella catch anche qua, sarà conseguenza della prima
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (e.getSource() == SetteButton) {
                try {
                    AzioneOrariButton click = new AzioneOrariButton("19:00");
                    //Dopo essere passata dal DBManager (in cui va nella catch segnata)
                    //Finisce nella catch anche qua, sarà conseguenza della prima
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
