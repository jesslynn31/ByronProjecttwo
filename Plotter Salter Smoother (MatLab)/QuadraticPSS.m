% this is the quadratic being plotted, salted and smoothed!
% -50 - 50 data points.
% salted by 2000
% smoothed by using movmean and 5.
% blue = original, red = salted, green = smoothed.

f = @(x) x.^2 + 3*x + 2;
x = -50:1:50;
yOriginal = f(x);
saltMagnitude = 2000;
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
