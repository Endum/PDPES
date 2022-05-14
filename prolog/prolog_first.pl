search(X, [X|_]).
search(X, [_|Xs]) :- search(X, Xs).

search_two(E, L) :- search_two(E, L, f).
search_two(E, [E|T], f) :- search_two(E, T, t).
search_two(E, [_|T], f) :- search_two(E, T, f).
search_two(E, [_|T], t) :- search(E, T).

search_anytwo(E, [E|T]) :- search(E, T).
search_anytwo(E, [_|T]) :- search_anytwo(E, T).

size([], 0).
size([_|Xs], N) :- size(Xs,N2), N is N2 + 1.

%size([], zero).
%size([_|T], s(X)) :- size(T, X).

sum(L, S) :- sum(L, S, 0).
sum([], C, C).
sum([E|T], S, C) :- C2 is C + E, sum(T, S, C2).

max([E|T], M) :- max([E|T], M, E).
max([], M, M).
max([E|T], M, Tm) :- E > Tm, !, max(T, M, E).
max([E|T], M, Tm) :- max(T, M, Tm).

maxmin([E|T], Ma, Mi) :- maxmin([E|T], Ma, Mi, E, E).
maxmin([], Mat, Mit, Mat, Mit).
maxmin([E|T], Ma, Mi, Mat, Mit) :- E > Mat, E < Mit, !, maxmin(T, Ma, Mi, E, E).
maxmin([E|T], Ma, Mi, Mat, Mit) :- E =< Mat, E < Mit, !, maxmin(T, Ma, Mi, Mat, E).
maxmin([E|T], Ma, Mi, Mat, Mit) :- E > Mat, E >= Mit, !, maxmin(T, Ma, Mi, E, Mit).
maxmin([E|T], Ma, Mi, Mat, Mit) :- E =< Mat, E >= Mit, maxmin(T, Ma, Mi, Mat, Mit).

same([], []).
same([X|Xs],[X|Ys]) :- same(Xs, Ys).

all_bigger([], []).
all_bigger([E1|T1], [E2|T2]) :- E1 > E2, all_bigger(T1, T2).

sublist([], _).
sublist([E|T], L) :- search(E, L), sublist(T, L).

seq(0, []).
seq(N, [0|T]) :- N2 is N - 1, seq(N2, T).

seqR(0, [0]).
seqR(N, [N|T]) :- N2 is N - 1, seqR(N2, T).

seqR2(N, L) :- seqR2(N, L, 0).
seqR2(N, [], C) :- C > N.
seqR2(N, [C|T], C) :- E is C + 1, seqR2(N, T, E).

% last(List, N)
% example: last([0, 3, 2, 4, 6], 6).
last([X], X).
last([E|T], N) :- last(T, N).
% last([0, 3, 2, 4, 6], X).  yes X / 6.
% last([0, 2, 8], 2).        no.
% last([], X).               no.

% map(List, List)
% example: map([0, 1, 2], [1, 2, 3]).
map([], []).
map([E1|T1], [E2|T2]) :- E2 is E1 + 1, map(T1, T2).
%map([E1|T1], [E2|T2]) :- E1 is E2 - 1, map(T1, T2).
% map([0,1,2], X).				yes X / [1,2,3].
% map([0,1,2], [1,2,4]).	no.
% map([], X).							yes X / [].

% filter(List, List)
% example: filter([0, -1, 2], [2]).
filter([], []).
filter([E|T], [E|T2]) :- E > 0, !, filter(T, T2).
filter([E|T], L) :- filter(T, L).
% filter([-100,-1,2], X).			yes X / [2].
% filter([1,-1,1], [1,1,1]).	no.

% count(List, N)
% example: count([4, 2, -1, 3], 3).
count(L, N) :- count(L, N, 0).
count([], C, C).
count([E|T], N, C) :- E > 0, !, C2 is C + 1, count(T, N, C2).
count([_|T], N, C) :- count(T, N, C).
% count([4,-2,-1,3], X).	yes X / 2.
% count([0,1,2], 3).			no.

% find(List, N).
% find([-1, 0, 1, 2], 2).
% find([-2, -1, 0], 3).
find(L, N) :- find(L, N, 0).
find([], N, N).
find([E|_], I, I) :- E > 0, !.
find([_|T], N, I) :- I2 is I + 1, find(T, N, I2).
% find([-2, 0, 1, -1], X).	yes X / 2.
% find([-1, 0, -1], 1).			no.

% dropRight(List, N, List)
% example: dropRight([0, 1, 2, 3], 2, [0, 1]).
dropRight(L, N, []) :- size(L, M), N >= M.
dropRight([E|T], N, [E]) :- size(T, N), !.
dropRight([E|T], N, [E|T2]) :- dropRight(T, N, T2).
% dropRight([0,1,2,3], 1, X).				yes X / [0,1,2].
% dropRight([0,1,2], 0, [0,1,2]).	yes.
% dropRight([0,5,2], 1, [0]).				no.

% dropWhile(List, List)
% example: dropWhile([1, 2, 0, 3, 4], [0, 3, 4]).
dropWhile([], []).
dropWhile([E|T], L) :- E > 0, !, dropWhile(T, L).
dropWhile(L, L).
% dropWhile([1, 2, 3, 4], X).		yes X / [].
% dropWhile([1, 2, 3, 0], []) 	no.

% partition(List, List, List)
% example: partition([1,2,3,0,4,5,6], [1,2,3], [0,4,5,6]).
partition(Li, Ll, Lr) :- dropWhile(Li, Lr), size(Lr, Sr), dropRight(Li, Sr, Ll).
% partition([3,0,2], X, Y).		yes X / [3], Y / [0,2].
% partition([1,2,3], X, Y).		yes X / [1,2,3], Y / [].
% partition([1,0], [1], []). no.

% reversed(List, List)
% example: reversed([0,1,2], [2,1,0]).
reversed([], []).
reversed(Li, [E|T]) :- last(Li, E), dropRight(Li, 1, Lo), reversed(Lo, T).
% reversed([0,1,2,3,4], X).		yes, infinite volte.
% Si generano infinite soluzioni, non mi è chiaro perchè.

% drop(List, N, List)
% example: drop([0,1,2],2,[2]).
drop(Li, N, Lo) :- reversed(Li, Lr), dropRight(Lr, N, Lrd), reversed(Lrd, Lo).
% drop([1,2,3],1,X).			yes X / [2,3].
% drop([2,1,3],2,[2,1])		no.

% take(List, N, List)
% example: take([4,5,6], 1, [4]).
take(Li, N, Lo) :- size(Li, Si), D is Si - N, max([0,D], M), dropRight(Li, M, Lo).
% take([4,5,6], 2, X).		yes X / [4,5].
% take([1,2], 3, X).			yes X / [1,2].
% take([3,4,5],1,[4,5])		no.

% zip(List, List, List)
% example: zip([1,2,3], [a,b,c], [[1,a],[2,b],[3,c]]).
zip([], [], []).
zip([E1|T1], [E2|T2], [E|T]) :- E = [E1,E2], zip(T1, T2, T).
% zip([3,4], [a,d], X).		yes X / [[3,a],[4,d]].
% zip([3,4,5], [a,d], X)	no.
