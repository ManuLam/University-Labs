from bs4 import BeautifulSoup
import plotly.graph_objects as go
from prettytable import PrettyTable
import urllib

# Read in our URL link
file = urllib.request.urlopen('http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML_WithNumMins?StationCode=MYNTH&NumMins=90&format=xml')
data = file.read()  # Read data from the URL link as a file
file.close()  # Close the file

soup = BeautifulSoup(data, "lxml")  # Parse the XML data into a BeautifulSoup Object


def extractor(tag_list, invert=False):
    """
    A function to extract all the wanted tags from our XML File

    :param tag_list: A list of wanted tags to be extracted
    :return: A formatted list of information || example: [['Dublin Connolly', 'Sligo', '11:34', '11:36', '14:15'], ['Dublin Connolly', 'Maynooth', '11:58', '11:57', '11:58']]
    """

    info = [extract_tag(tag) for tag in tag_list]

    if invert is True:
        data_list = [[info[column][row] for column in range(len(info))] for row in range(len(info[0]))]
    else:
        data_list = [[info[row][column] for column in range(len(info[0]))] for row in range(len(info))]

    return data_list


def extract_tag(tag):
    """
    A function to extract a tag from a XML file

    :param tag: Finds a specific tag inside our XML file
    :return: A list of the tags found
    """

    return [values.text for values in soup.findAll(tag)]


def print_console_table(info):
    """
    A function to print the timetable to the command prompt

    :param info: A 2D List to be filled into the table
    """

    table = PrettyTable()
    table.field_names = tag_list.keys()

    for row in info:
        table.add_row(row)

    print(table)


if __name__ == "__main__":
    tag_list = {"Departure Station": "origin", "Arrival Station": "destination",
                "Expected Departure Time": "expdepart", "Expected Arrival Time": "exparrival", "Arrival Destination Time": "destinationtime"}

    extracted_info = extractor(tag_list.values())

    # Create data plot with header and cell data
    fig = go.Figure(data=[go.Table(header=dict(values=list(tag_list.keys())),
                                   cells=dict(values=extracted_info))])
    # Update title of the plot
    fig.update_layout(title="Train Timetable")

    # Export to a html file
    fig.write_html("TrainTimetable.html")
    fig.show()

    # Transpose the information for printing out
    extracted_info_inverted = extractor(tag_list.values(), invert=True)
    print_console_table(extracted_info_inverted)
