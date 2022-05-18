function varargout = Responsi_123200103(varargin)
% RESPONSI_123200103 MATLAB code for Responsi_123200103.fig
%      RESPONSI_123200103, by itself, creates a new RESPONSI_123200103 or raises the existing
%      singleton*.
%
%      H = RESPONSI_123200103 returns the handle to a new RESPONSI_123200103 or the handle to
%      the existing singleton*.
%
%      RESPONSI_123200103('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in RESPONSI_123200103.M with the given input arguments.
%
%      RESPONSI_123200103('Property','Value',...) creates a new RESPONSI_123200103 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before Responsi_123200103_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to Responsi_123200103_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help Responsi_123200103

% Last Modified by GUIDE v2.5 18-May-2022 14:45:28

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @Responsi_123200103_OpeningFcn, ...
                   'gui_OutputFcn',  @Responsi_123200103_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before Responsi_123200103 is made visible.
function Responsi_123200103_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to Responsi_123200103 (see VARARGIN)

% Choose default command line output for Responsi_123200103
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes Responsi_123200103 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = Responsi_123200103_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in tampilkan_103.
function tampilkan_103_Callback(hObject, eventdata, handles)
% hObject    handle to tampilkan_103 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global colomA;
[num,txt,colomA] = xlsread('Home.xlsx','B2:F51');
set(handles.uitable1,'data',colomA);


% --- Executes on button press in hasil_103.
function hasil_103_Callback(hObject, eventdata, handles)
% hObject    handle to hasil_103 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
data = xlsread('Home.xlsx', 'C2:F51');
k = [0 0 1 1]
bobot = xlsread('Home.xlsx','H2:H5');
disp(data)
disp(bobot)

[m,n] = size(data);
bobot = bobot./sum(bobot);

for j = 1:n,
    if k(j)==0, bobot(j)=-1*bobot(j);
    end;
end;
for i = 1:m,
    S(i)=prod(data(i,:).^bobot);
end

V = S/sum(S);


