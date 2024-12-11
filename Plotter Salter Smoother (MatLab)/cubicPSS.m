% x values -50 to 50 by 1 each.
% function is a cubic
% taking absolute value of the yOriginal * 20% of it for the salt magnitude
% range for smoothing is 5
% original function = blue, salted function = red, smoothed function = green.


x = -50:1:50;
yOriginal = 1 * x.^3 + 4 * x.^2 + 3 * x + 6;
saltMagnitude = max(abs(yOriginal)) * 0.20;
ySalted = yOriginal + saltMagnitude * (rand(size(yOriginal)) - 0.5);
range = 5;
ySmoothed = movmean(ySalted, range);
plot(x, yOriginal, '-b', 'LineWidth', 1.5);
hold on;
plot(x, ySalted, '-r');
plot(x, ySmoothed, '-g', 'LineWidth', 1.5);
legend('Original', 'Salted', 'Smoothed');
xlabel('x');
ylabel('y');
grid on;
hold off;

