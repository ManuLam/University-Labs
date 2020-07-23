import tensorflow as tf
from tensorflow.keras import layers

# # Build a simple model
model = tf.keras.Sequential()
# Take 10 Inputs, apply a 16 layer with relu activation, 12 layer and a sigmoid layer
model.add(layers.Dense(16, activation='relu', input_dim=10))
model.add(layers.Dense(12, activation='relu'))
model.add(layers.Dense(1, activation='sigmoid'))

# load in training data
train_data = []
train_label = []
for line in open('train.txt'):
    vals = line.split()
    train_data.append(map(float, vals[:-1]))
    train_label.append(map(float, vals[-1]))

# load in testing data
test_data = []
for line in open('test.txt'):
    vals = line.split()
    test_data.append(map(float, vals))
    
# Setting up our model, using binary_crossentropy since we only have 0 | 1 output
model.compile(optimizer="adam",
              metrics=['accuracy'],
              loss='binary_crossentropy')

def train_model(fit=False, save_weights=False):


    if fit:
        # Fitting our training labels with the training data, 250 epochs for more iterations, 64 batch
        model.fit(train_data, train_label, epochs=250, batch_size=64)

        if save_weights:
            # My best attempt was around 72%
            # Save weights to a HDF5 file
            model.save_weights('assignment1.h5', save_format='h5')


def predict_label_file():
    # Restore the model's state
    model.load_weights('assignment1.h5')
    result = model.predict(test_data, batch_size=64)
    f = open("labels.txt", "w")

    # Not entirely sure if this is the way of printing out the binary labels 0 | 1
    for x in result:
        if x >= .5:
            f.write('1\n')
        else:
            f.write('0\n')


if __name__ == "__main__":
    train_model(fit=True, save_weights=False)
    predict_label_file()
