% dropAny (? Elem ,? List ,? OutList )
dropAny(X, [X|T], T).
dropAny(X, [H|Xs], [H|L]) :- dropAny(X, Xs, L).

dropFirst(X, [X|T], T) :- !. 
dropFirst(X, [H|Xs], [H|L]) :- dropFirst(X, Xs, L).

dropLast(X, [H|Xs], [H|L]) :- dropLast(X, Xs, L), !.
dropLast(X, [X|T], T).

dropAll(X, [], []).
dropAll(X, [X|T], R) :- dropAll(X, T, R), !.
dropAll(X, [H|T1], [H|T2]) :- dropAll(X, T1, T2).

 % fromList (+ List ,- Graph )
fromList([_], []).
fromList([H1, H2|T], [e(H1, H2)|L]) :- fromList([H2|T], L).

fromCircList([H|T], G) :- fromCircList(H, [H|T], G).
fromCircList(H, [H1], [e(H1, H)]).
fromCircList(H, [H1, H2|T], [e(H1, H2)|G]) :- fromCircList(H, [H2|T], G).

in_degree(G, N, R) :- in_degree(G, N, R, 0).
in_degree([], _, R, R).
in_degree([e(_,N)|G], N, R, C) :- C2 is C + 1, in_degree(G, N, R, C2), !.
in_degree([H|G], N, R, C) :- in_degree(G, N, R, C).

% Non funziona, perchè stiamo tentando di usare una variabile come una wildcard.
dropNode(G, N, OG) :- dropAll(e(N,_), G, G2), dropAll(e(_,N), G2, OG).

reaching(G, N, L) :- findall(R, member(e(N, R), G), L).

anypath(G, N1, N2, [e(N1,N2)]) :- member(e(N1,N2), G).
anypath(G, N1, N2, [e(N1, N3)|L]) :- member(e(N1, N3), G), anypath(G, N3, N2, L).

allreaching(G, N, L) :- findall(R, anypath(G, N, R, _), L).
