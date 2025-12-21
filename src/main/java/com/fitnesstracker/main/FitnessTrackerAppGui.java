package com.fitnesstracker.main;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import com.fitnesstracker.singleton.ActivityTracker;
import com.fitnesstracker.singleton.GoalManager;
import com.fitnesstracker.builder.FitnessPlan;
import com.fitnesstracker.builder.FitnessPlanBuilder;
import com.fitnesstracker.builder.FitnessPlanDirector;
import com.fitnesstracker.factory.Exercise;
import com.fitnesstracker.factory.ExerciseFactory;
import com.fitnesstracker.factory.NutritionPlan;
import com.fitnesstracker.factory.NutritionFactory;
import com.fitnesstracker.adapter.SmartWatchAPI;
import com.fitnesstracker.adapter.SmartWatchAdapter;
import com.fitnesstracker.adapter.FitnessData;
import com.fitnesstracker.decorator.BasicWorkout;
import com.fitnesstracker.decorator.Workout;
import com.fitnesstracker.decorator.CaloriesTrackerDecorator;
import com.fitnesstracker.decorator.HeartRateDecorator;
import com.fitnesstracker.decorator.DietPlanDecorator;

public class FitnessTrackerAppGui extends JFrame {

    private final Color PRIMARY = new Color(52, 152, 219);
    private final Color SUCCESS = new Color(46, 204, 113);
    private final Color WARNING = new Color(241, 196, 15);
    private final Color DANGER = new Color(231, 76, 60);
    private final Color BG = new Color(236, 240, 241);

    public FitnessTrackerAppGui() {
        setTitle("💪 Fitness Tracker - All Design Patterns");
        setSize(1100, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.BOLD, 14));

        tabs.add("🏠 Home", homePanel());
        tabs.add("📊 Singleton", singletonPanel());
        tabs.add("🔨 Builder", builderPanel());
        tabs.add("🏭 Factory", factoryPanel());
        tabs.add("🔌 Adapter", adapterPanel());
        tabs.add("🎨 Decorator", decoratorPanel());

        add(tabs);
    }

    // =================== HOME ===================
    private JPanel homePanel() {
        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBackground(new Color(245, 247, 250));
        panel.setBorder(new EmptyBorder(30, 40, 30, 40));

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(245, 247, 250));

        JLabel title = new JLabel("💪 FITNESS TRACKER APPLICATION");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(41, 128, 185));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Your Complete Fitness Management System");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(new Color(127, 140, 141));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(title);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subtitle);
        headerPanel.add(Box.createVerticalStrut(30));

        // Main Content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(25, 25, 25, 25)
        ));

        // Goals
        JLabel goalsTitle = new JLabel("🎯 Application Goals");
        goalsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        goalsTitle.setForeground(new Color(52, 73, 94));

        JTextArea goalsText = new JTextArea();
        goalsText.setEditable(false);
        goalsText.setFont(new Font("Arial", Font.PLAIN, 14));
        goalsText.setBackground(Color.WHITE);
        goalsText.setBorder(new EmptyBorder(15, 0, 15, 0));
        goalsText.setText(
            "This Fitness Tracker helps you achieve your health goals:\n\n" +
            "• Track daily activities and monitor progress\n" +
            "• Set and manage fitness goals effectively\n" +
            "• Create custom fitness plans for your needs\n" +
            "• Generate exercise routines and nutrition plans\n" +
            "• Integrate with smart devices for real-time data\n" +
            "• Customize workouts with additional features"
        );

        // Patterns
        JLabel patternsTitle = new JLabel("⚙️ Design Patterns");
        patternsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        patternsTitle.setForeground(new Color(52, 73, 94));

        JPanel cardsPanel = new JPanel(new GridLayout(3, 2, 15, 15));
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        cardsPanel.add(createPatternCard("📊 SINGLETON", "Activity Tracking", 
            "Single instance management\nGoal: Centralized data tracking", PRIMARY));
        cardsPanel.add(createPatternCard("🔨 BUILDER", "Fitness Plans", 
            "Step-by-step construction\nGoal: Custom workout plans", SUCCESS));
        cardsPanel.add(createPatternCard("🏭 FACTORY", "Exercise Creation", 
            "Object creation patterns\nGoal: Generate routines", WARNING));
        cardsPanel.add(createPatternCard("🔌 ADAPTER", "Device Integration", 
            "Interface compatibility\nGoal: Smart watch sync", new Color(155, 89, 182)));
        cardsPanel.add(createPatternCard("🎨 DECORATOR", "Workout Custom", 
            "Dynamic features\nGoal: Enhanced workouts", DANGER));

        JPanel startCard = new JPanel();
        startCard.setLayout(new BoxLayout(startCard, BoxLayout.Y_AXIS));
        startCard.setBackground(new Color(236, 240, 241));
        startCard.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 2));

        JLabel startIcon = new JLabel("🚀");
        startIcon.setFont(new Font("Arial", Font.PLAIN, 40));
        startIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel startText = new JLabel("<html><center>GET STARTED<br><br>Click tabs above!</center></html>");
        startText.setFont(new Font("Arial", Font.BOLD, 14));
        startText.setAlignmentX(Component.CENTER_ALIGNMENT);

        startCard.add(Box.createVerticalStrut(20));
        startCard.add(startIcon);
        startCard.add(Box.createVerticalStrut(10));
        startCard.add(startText);
        startCard.add(Box.createVerticalStrut(20));

        cardsPanel.add(startCard);

        contentPanel.add(goalsTitle);
        contentPanel.add(goalsText);
        contentPanel.add(Box.createVerticalStrut(25));
        contentPanel.add(patternsTitle);
        contentPanel.add(cardsPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // =================== SINGLETON ===================
    private JPanel singletonPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        topPanel.setBackground(BG);

        // Activity Tracker
        JPanel activityPanel = createSection("📊 Activity Tracker", PRIMARY);
        JTextField activityField = createTextField();
        JButton btnAddActivity = createButton("Add Activity", SUCCESS);
        JTextArea activityOutput = createOutputArea(4);

        JPanel actInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actInput.setBackground(Color.WHITE);
        actInput.add(new JLabel("Enter Activity:"));
        actInput.add(activityField);
        actInput.add(btnAddActivity);

        activityPanel.add(actInput);
        activityPanel.add(new JScrollPane(activityOutput));

        // Goal Manager
        JPanel goalPanel = createSection("🎯 Goal Manager", SUCCESS);
        JTextField goalField = createTextField();
        JButton btnAddGoal = createButton("Add Goal", PRIMARY);
        JTextArea goalOutput = createOutputArea(4);

        JPanel goalInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        goalInput.setBackground(Color.WHITE);
        goalInput.add(new JLabel("Enter Goal:"));
        goalInput.add(goalField);
        goalInput.add(btnAddGoal);

        goalPanel.add(goalInput);
        goalPanel.add(new JScrollPane(goalOutput));

        // Actions
        btnAddActivity.addActionListener(e -> {
            String activity = activityField.getText().trim();
            if (!activity.isEmpty()) {
                ActivityTracker.getInstance().addActivity(activity);
                activityOutput.append("- " + activity + "\n");
                activityField.setText("");
            }
        });

        btnAddGoal.addActionListener(e -> {
            String goal = goalField.getText().trim();
            if (!goal.isEmpty()) {
                GoalManager.getInstance().addGoal(goal);
                goalOutput.append("- " + goal + "\n");
                goalField.setText("");
            }
        });

        topPanel.add(activityPanel);
        topPanel.add(goalPanel);

        // Show Console Button
        JButton btnShow = createButton("Show in Console (Like Integration)", DANGER);
        btnShow.addActionListener(e -> {
            System.out.println("\n===== SINGLETON PATTERN =====");
            ActivityTracker.getInstance().showActivities();
            System.out.println();
            GoalManager.getInstance().showGoals();
            System.out.println("=============================\n");
            JOptionPane.showMessageDialog(this, "Check console output!");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BG);
        buttonPanel.add(btnShow);

        panel.add(topPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // =================== BUILDER ===================
    private JPanel builderPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel contentPanel = createSection("🔨 Fitness Plan Builder", PRIMARY);

        JTextArea output = createOutputArea(18);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton btnCustom = createButton("Build Custom Plan", SUCCESS);
        JButton btnBeginner = createButton("Beginner Plan", PRIMARY);
        JButton btnAdvanced = createButton("Advanced Plan", DANGER);

        buttonPanel.add(btnCustom);
        buttonPanel.add(btnBeginner);
        buttonPanel.add(btnAdvanced);

        // Actions
        btnCustom.addActionListener(e -> {
            FitnessPlan plan = new FitnessPlanBuilder()
                    .setId(1)
                    .setPlanName("Custom Plan")
                    .setDuration(45)
                    .setHasCardio(true)
                    .setHasStrengthTraining(true)
                    .setHasStretching(false)
                    .setCaloriesBurned(350)
                    .build();
            output.setText("✓ Custom Plan Created!\n\n" + plan.toString());
        });

        btnBeginner.addActionListener(e -> {
            FitnessPlanDirector director = new FitnessPlanDirector(new FitnessPlanBuilder());
            FitnessPlan plan = director.constructBeginnerPlan();
            output.setText("✓ Beginner Plan Created!\n\n" + plan.toString());
        });

        btnAdvanced.addActionListener(e -> {
            FitnessPlanDirector director = new FitnessPlanDirector(new FitnessPlanBuilder());
            FitnessPlan plan = director.constructAdvancedPlan();
            output.setText("✓ Advanced Plan Created!\n\n" + plan.toString());
        });

        contentPanel.add(buttonPanel);
        contentPanel.add(new JScrollPane(output));

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }

    // =================== FACTORY ===================
    private JPanel factoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel contentPanel = createSection("🏭 Exercise & Nutrition Factory", WARNING);

        JTextArea output = createOutputArea(18);

        // Exercise Buttons
        JPanel exPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        exPanel.setBackground(Color.WHITE);
        exPanel.add(new JLabel("Create Exercise:"));

        JButton btnCardio = createButton("Cardio", PRIMARY);
        JButton btnStrength = createButton("Strength", SUCCESS);
        JButton btnFlex = createButton("Flexibility", WARNING);

        exPanel.add(btnCardio);
        exPanel.add(btnStrength);
        exPanel.add(btnFlex);

        // Nutrition Buttons
        JPanel nutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        nutPanel.setBackground(Color.WHITE);
        nutPanel.add(new JLabel("Create Nutrition Plan:"));

        JButton btnLoss = createButton("Weight Loss", DANGER);
        JButton btnGain = createButton("Muscle Gain", SUCCESS);

        nutPanel.add(btnLoss);
        nutPanel.add(btnGain);

        // Combine
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(exPanel);
        buttonPanel.add(nutPanel);

        // Actions
        btnCardio.addActionListener(e -> {
            Exercise ex = ExerciseFactory.createExercise("CARDIO", "Running", 30);
            output.setText("✓ Exercise Created!\n\nType: CARDIO\nName: Running\nDuration: 30 min\nCalories: 300");
        });

        btnStrength.addActionListener(e -> {
            Exercise ex = ExerciseFactory.createExercise("STRENGTH", "Weight Lifting", 45);
            output.setText("✓ Exercise Created!\n\nType: STRENGTH\nName: Weight Lifting\nDuration: 45 min\nCalories: 360");
        });

        btnFlex.addActionListener(e -> {
            Exercise ex = ExerciseFactory.createExercise("FLEXIBILITY", "Yoga", 60);
            output.setText("✓ Exercise Created!\n\nType: FLEXIBILITY\nName: Yoga\nDuration: 60 min\nCalories: 180");
        });

        btnLoss.addActionListener(e -> {
            NutritionPlan plan = NutritionFactory.createPlan("WEIGHT_LOSS");
            output.setText("✓ Nutrition Plan Created!\n\nType: Weight Loss\nGoal: Lose weight through caloric deficit\nDaily Calories: 1800\nMacros: Protein 30%, Carbs 40%, Fats 30%");
        });

        btnGain.addActionListener(e -> {
            NutritionPlan plan = NutritionFactory.createPlan("MUSCLE_GAIN");
            output.setText("✓ Nutrition Plan Created!\n\nType: Muscle Gain\nGoal: Build muscle through caloric surplus\nDaily Calories: 2800\nMacros: Protein 35%, Carbs 45%, Fats 20%");
        });

        contentPanel.add(buttonPanel);
        contentPanel.add(new JScrollPane(output));

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }

    // =================== ADAPTER ===================
    private JPanel adapterPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel contentPanel = createSection("🔌 Smart Watch Adapter", SUCCESS);

        JTextArea output = createOutputArea(15);

        JButton btnFetch = createButton("Fetch Smart Watch Data", PRIMARY);
        btnFetch.setFont(new Font("Arial", Font.BOLD, 16));

        btnFetch.addActionListener(e -> {
            SmartWatchAPI api = new SmartWatchAPI();
            FitnessData adapter = new SmartWatchAdapter(api);
            
            output.setText(
                "✓ Smart Watch Data Retrieved!\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "📱 Device: Smart Watch Pro\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Steps: " + adapter.getDailySteps() + "\n" +
                "Calories Burned: " + adapter.getBurnedCalories() + "\n\n" +
                "Status: ✓ Connected\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnFetch);

        contentPanel.add(buttonPanel);
        contentPanel.add(new JScrollPane(output));

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }

    // =================== DECORATOR ===================
    private JPanel decoratorPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BG);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel contentPanel = createSection("🎨 Workout Decorator", DANGER);

        JTextArea output = createOutputArea(18);

        JButton btnGenerate = createButton("Generate Full Workout", WARNING);
        btnGenerate.setFont(new Font("Arial", Font.BOLD, 16));

        btnGenerate.addActionListener(e -> {
            Workout workout = new BasicWorkout();
            workout = new CaloriesTrackerDecorator(workout);
            workout = new HeartRateDecorator(workout);
            workout = new DietPlanDecorator(workout);

            output.setText(
                "✓ Custom Workout Generated!\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                workout.getDescription() +
                "\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "💪 Total Calories Burned: " + workout.getCalories() + " cal\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnGenerate);

        contentPanel.add(buttonPanel);
        contentPanel.add(new JScrollPane(output));

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }

    // =================== HELPER METHODS ===================
    private JPanel createSection(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 2),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(color);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        return panel;
    }

    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(8, 15, 8, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField(20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private JTextArea createOutputArea(int rows) {
        JTextArea area = new JTextArea(rows, 50);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(new EmptyBorder(10, 10, 10, 10));
        return area;
    }

    private JPanel createPatternCard(String title, String subtitle, String description, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 2),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(color);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleLabel.setForeground(new Color(52, 73, 94));

        JTextArea descArea = new JTextArea(description);
        descArea.setEditable(false);
        descArea.setFont(new Font("Arial", Font.PLAIN, 11));
        descArea.setForeground(new Color(127, 140, 141));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setBackground(Color.WHITE);

        card.add(titleLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(subtitleLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(descArea);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FitnessTrackerAppGui().setVisible(true);
        });
    }
}