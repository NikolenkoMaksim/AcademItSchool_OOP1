package ru.oop.nikolenko.minesweeper.veiw;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LeaderboardsView {
    public static void createLeaderboardsView(String[][] championsNames, Integer[][] championsTimes, String[] categoriesNames) {
        if (championsNames.length != categoriesNames.length) {
            throw new IllegalArgumentException("championsNames.length = " + championsNames.length
                    + " is not equal categoriesNames.length = " + categoriesNames.length);
        }

        if (championsNames.length != championsTimes.length) {
            throw new IllegalArgumentException("championsNames.length = " + championsNames.length
                    + " is not equal championsTimes.length = " + championsTimes.length);
        }

        if (championsNames[0].length != championsTimes[0].length) {
            throw new IllegalArgumentException("championsNames[0].length = " + championsNames[0].length
                    + " is not equal championsTimes[0].length = " + championsTimes[0].length);
        }

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            JFrame leaderboardsFrame = new JFrame("Leaderboard");

            final int frameDefaultWidth = 200;
            final int frameDefaultHeight = 500;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            leaderboardsFrame.setLocation((screenSize.width - frameDefaultWidth) / 2, (screenSize.height - frameDefaultHeight) / 2);
            leaderboardsFrame.setSize(frameDefaultWidth, frameDefaultHeight);
            leaderboardsFrame.setResizable(false);
            leaderboardsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            leaderboardsFrame.setVisible(true);
            leaderboardsFrame.getRootPane().setBorder(new EmptyBorder(15, 15, 15, 15));

            GridBagLayout leaderboardsFrameLayout = new GridBagLayout();
            leaderboardsFrame.setLayout(leaderboardsFrameLayout);

            GridBagConstraints leaderboardsConstraints = new GridBagConstraints();

            leaderboardsConstraints.anchor = GridBagConstraints.CENTER;
            leaderboardsConstraints.fill = GridBagConstraints.NONE;
            leaderboardsConstraints.gridheight = 1;
            leaderboardsConstraints.gridwidth = GridBagConstraints.REMAINDER;
            leaderboardsConstraints.gridx = GridBagConstraints.RELATIVE;
            leaderboardsConstraints.gridy = GridBagConstraints.RELATIVE;
            leaderboardsConstraints.insets = new Insets(0, 0, 5, 0);
            leaderboardsConstraints.ipadx = 0;
            leaderboardsConstraints.ipady = 0;
            leaderboardsConstraints.weightx = 1.0;
            leaderboardsConstraints.weighty = 1.0;

            JLabel title = new JLabel("Leaderboard");
            title.setFont(new Font("", Font.BOLD, 13));
            leaderboardsFrameLayout.setConstraints(title, leaderboardsConstraints);
            leaderboardsFrame.add(title);

            for (int i = 0; i < championsNames.length; i++) {
                JLabel categoryName = new JLabel(categoriesNames[i]);
                leaderboardsConstraints.anchor = GridBagConstraints.CENTER;
                leaderboardsConstraints.fill = GridBagConstraints.NONE;
                leaderboardsConstraints.insets = new Insets(5, 0, 5, 0);
                leaderboardsFrameLayout.setConstraints(categoryName, leaderboardsConstraints);
                leaderboardsFrame.add(categoryName);

                for (int j = 0; j < championsNames[0].length; j++) {
                    JLabel gamerNameLabel = new JLabel();

                    if (championsNames[i][j] != null) {
                        gamerNameLabel.setText((j + 1) + ". " + championsNames[i][j]);
                    } else {
                        gamerNameLabel.setText((j + 1) + ".");
                    }

                    leaderboardsConstraints.anchor = GridBagConstraints.WEST;
                    leaderboardsConstraints.fill = GridBagConstraints.HORIZONTAL;
                    leaderboardsConstraints.gridwidth = 1;
                    leaderboardsConstraints.insets = new Insets(0, 0, 0, 0);
                    leaderboardsFrameLayout.setConstraints(gamerNameLabel, leaderboardsConstraints);
                    leaderboardsFrame.add(gamerNameLabel);

                    JLabel gamerTimeLabel = new JLabel();
                    gamerTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

                    if (championsTimes[i][j] != null) {
                        gamerTimeLabel.setText(String.valueOf(championsTimes[i][j]));
                    }

                    leaderboardsConstraints.gridwidth = GridBagConstraints.REMAINDER;
                    leaderboardsFrameLayout.setConstraints(gamerTimeLabel, leaderboardsConstraints);
                    leaderboardsFrame.add(gamerTimeLabel);
                }
            }
        });
    }
}

