import requests
import json

api_url = 'https://trello.com/evavlada/boards'
api_key = ''
api_token = ''

def get_user_id():
    url = "https://api.trello.com/1/actions/{id}"
    query = {
        'key': api_key,
        'token': api_token,
    }

    # send a request and store the response in a variable
    response = requests.request('GET',
                                url,
                                query)

    if response.status_code == 200:
        # return user ID
        return response.json()['idMember']

    else:
        # print an error code
        print('Error in user ID request: {}'.format(response.text))

    # get the user id
    user_id = get_user_id()

    # create a new board
    def create_new_board(board_name, board_description):
        url = "https://api.trello.com/1/boards/{id}"

        headers = {
            "Accept": "application/json"
        }

        response = requests.request(
            "GET",
            url,
            headers,
            query
        )

        # send a request and store the response in a variable
        response = requests.request('GET', url, query)

        # if the the request was successful
        if response.status_code == 200:
            print('The new board "{}" is created successfully.'.format(board_name))

            # if the request was unsuccessful
        else:
            print('Error in board creation: {}'.format(response.text))


def add_todo_items(board_name, team_member_name):
    # get the board info if the board exists
    board_info = board_name


